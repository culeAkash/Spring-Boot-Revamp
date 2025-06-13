package spring.boot.revamp.beanScopes.request;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class ReqUser {

    public ReqUser(){
        System.out.println("ReqUser object initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("ReqUser object hashCode: " + this.hashCode());
    }
}
