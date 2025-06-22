package spring.boot.revamp.filters.multipleInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MultipleInterceptorAppConfig implements WebMvcConfigurer {

    private final MyCustomInterceptor1 myCustomInterceptor1;

    private final MyCustomInterceptor2 myCustomInterceptor2;

    public MultipleInterceptorAppConfig(MyCustomInterceptor1 myCustomInterceptor1,MyCustomInterceptor2 myCustomInterceptor2){
        this.myCustomInterceptor1 = myCustomInterceptor1;
        this.myCustomInterceptor2 = myCustomInterceptor2;
    }


    // prehandle methods of the interceptors get called in the same order as specified in the method
    // postHandle and afterCompletion invoked in reverse order coming back after invoking the controller method

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myCustomInterceptor1)
                .addPathPatterns("/api/v1/multiple/interceptors/*")
                .excludePathPatterns("/api/v1/multiple/interceptors/update","/api/v1/multiple/interceptors/delete");

        registry.addInterceptor(myCustomInterceptor2)
                .addPathPatterns("/api/v1/multiple/interceptors/*")
                .excludePathPatterns("/api/v1/multiple/interceptors/update");
    }
}
