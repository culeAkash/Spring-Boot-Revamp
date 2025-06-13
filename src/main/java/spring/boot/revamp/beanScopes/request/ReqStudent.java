package spring.boot.revamp.beanScopes.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring.boot.revamp.beanScopes.prototype.ProtUser;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReqStudent {

    ReqUser user;

    @Autowired
    public ReqStudent(ReqUser user){
        System.out.println("ReqStudent object initialized");
        this.user = user;
    }

    @PostConstruct
    public void init(){
        System.out.println("ReqStudent object hashCode: " + this.hashCode() + ", ReqUser object hashCode: " + this.user.hashCode());
    }
}
