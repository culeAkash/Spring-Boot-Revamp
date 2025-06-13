package spring.boot.revamp.beanScopes.singleton;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beanscopes/test2")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TestController2 {


    private final User2 user;

    @Autowired
    public TestController2(User2 user){
        this.user = user;
        System.out.println("TestController2 instance initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestController2 object hashCode: " + this.hashCode() + ", User2 object hashCode: " + this.user.hashCode());
    }
}
