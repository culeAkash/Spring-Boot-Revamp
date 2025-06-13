package spring.boot.revamp.beanScopes.session;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SessionUser {

    public SessionUser(){
        System.out.println("SessionUser object initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("SessionUser object hashCode: " + this.hashCode());
    }
}
