package spring.boot.revamp.beanLifecycle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.boot.revamp.beanLifecycle.models.User1;

@Configuration
public class Config {

    @Bean(name = "createUser")
    public User1 createUser(){
        return new User1("Akash","akash@gmail.com");
    }

}
