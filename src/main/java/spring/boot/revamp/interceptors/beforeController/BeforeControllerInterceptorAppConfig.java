package spring.boot.revamp.interceptors.beforeController;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Configure the Interceptor to be used for specific controllers
@Configuration
public class BeforeControllerInterceptorAppConfig implements WebMvcConfigurer {

    private final BeforeControllerInterceptor beforeControllerInterceptor;

    public BeforeControllerInterceptorAppConfig(BeforeControllerInterceptor beforeControllerInterceptor){
        this.beforeControllerInterceptor = beforeControllerInterceptor;
    }

    // configure the api routes to intercept using the Custom Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(beforeControllerInterceptor)
                .addPathPatterns("/api/v1/interceptor/*")
                .excludePathPatterns("/api/v1/interceptor/update","/api/v1/interceptor/delete");
    }
}
