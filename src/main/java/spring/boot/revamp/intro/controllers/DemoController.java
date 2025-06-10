package spring.boot.revamp.intro.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/intro/api")
public class DemoController {

    @GetMapping("/get")
    public ResponseEntity<String> getMapping(){
        return ResponseEntity.ok("Hello");
    }

}
