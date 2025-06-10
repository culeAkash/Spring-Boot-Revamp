package spring.boot.revamp.beanLifecycle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.revamp.beanLifecycle.models.User1;

@RestController
@RequestMapping("/api/v1/beanDemo")
public class BeanLifecycleDemoController {

    private final User1 user;

    @Autowired
    public BeanLifecycleDemoController(@Qualifier("createUser") User1 user){
        this.user =user;
    }



    @GetMapping("/getUser")
    public ResponseEntity<User1> getUser(){
        return ResponseEntity.ok(user);
    }

}
