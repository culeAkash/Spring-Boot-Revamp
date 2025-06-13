package spring.boot.revamp.dependencyInjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.revamp.dependencyInjection.models.User;

@RestController
@RequestMapping("/api/v1/di")
public class DIController {

    @Autowired
    User user;

    @GetMapping("/create")
    public ResponseEntity<Void> createDI(){
        System.out.println(user.hashCode());
        return ResponseEntity.ok(null);
    }
}
