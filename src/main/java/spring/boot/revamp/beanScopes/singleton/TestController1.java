package spring.boot.revamp.beanScopes.singleton;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beanscopes/test1")
public class TestController1 {


    private final User2 user;

    @Autowired
    public TestController1(User2 user){
        this.user = user;
        System.out.println("TestController1 instance initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestController1 object hashCode: " + this.hashCode() + ", User2 object hashCode: " + this.user.hashCode());
    }
}
