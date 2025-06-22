package spring.boot.revamp.filters.multipleFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleFilterAppConfig {

    // After creating the filters we can specify their orders it goes in the same order and comes out in reverse order

    @Bean
    public FilterRegistrationBean<MyFilter1> myFirstFilter(){
        FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter1());
        filterRegistrationBean.addUrlPatterns("/api/v1/multiple/interceptors/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> mySecondFilter(){
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.addUrlPatterns("/api/v1/multiple/interceptors/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
