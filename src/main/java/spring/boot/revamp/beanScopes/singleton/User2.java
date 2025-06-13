package spring.boot.revamp.beanScopes.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class User2 {

    public User2(){
        System.out.println("User2 initialization");
    }

    @PostConstruct
    public void init(){
        System.out.println("User2 object hashCode: " + this.hashCode());
    }
}
