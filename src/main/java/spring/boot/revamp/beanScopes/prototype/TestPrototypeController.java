package spring.boot.revamp.beanScopes.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beanScopes/prot")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestPrototypeController {

    private final ProtStudent student;
    private final ProtUser user;


    @Autowired
    public TestPrototypeController(ProtStudent student,ProtUser user){
        System.out.println("ProtTestController object initialized");
        this.student = student;
        this.user = user;
    }


    @PostConstruct
    public void init(){
        System.out.println("ProtTestController object hashCode : " + this.hashCode() +  ",user and student hashCode: " + this.user.hashCode() + "and " + this.student.hashCode());
    }

    @GetMapping("/createrTestProt")
    public ResponseEntity<Void> createTest(){
        System.out.println("Api invoked");
        return ResponseEntity.ok(null);
    }
}

