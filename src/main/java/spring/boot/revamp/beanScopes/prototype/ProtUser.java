package spring.boot.revamp.beanScopes.prototype;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtUser {

    public ProtUser(){
        System.out.println("ProtUser object initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("ProtUser object hashCode: " + this.hashCode());
    }
}
