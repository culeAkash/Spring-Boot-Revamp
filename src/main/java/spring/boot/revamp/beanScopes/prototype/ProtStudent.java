package spring.boot.revamp.beanScopes.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProtStudent {

    ProtUser user;

    @Autowired
    public ProtStudent(ProtUser user){
        System.out.println("ProtStudent object initialized");
        this.user = user;
    }

    @PostConstruct
    public void init(){
        System.out.println("ProtStudent object hashCode: " + this.hashCode() + ", ProtUser object hashCode: " + this.user.hashCode());
    }
}
