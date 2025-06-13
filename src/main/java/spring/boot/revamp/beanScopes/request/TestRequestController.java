package spring.boot.revamp.beanScopes.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.revamp.beanScopes.prototype.ProtStudent;
import spring.boot.revamp.beanScopes.prototype.ProtUser;

@RestController
@RequestMapping("/api/v1/beanScopes/req")
@Scope("request")
public class TestRequestController {

    @Autowired
    private ReqStudent student;

    @Autowired
    private ReqUser user;

    public TestRequestController(){
        System.out.println("ProtTestController object initialized");
    }


    @PostConstruct
    public void init(){
        System.out.println("TestRequestController object hashCode : " + this.hashCode() +  ",user and student hashCode: " + this.user.hashCode() + " and " + this.student.hashCode());
    }

    @GetMapping("/createrTestReq")
    public ResponseEntity<Void> createTest(){
        System.out.println("Api invoked");
        return ResponseEntity.ok(null);
    }
}
