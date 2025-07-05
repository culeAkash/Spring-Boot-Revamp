package spring.boot.revamp.jpaExamples.relationships.oneToManyExamples;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jpaOneToMany")
public class OneToManyController {

    private final OneToManyService oneToManyService;

    public OneToManyController(OneToManyService service){
        this.oneToManyService = service;
    }


    @PostMapping("/createUser")
    public ResponseEntity<UserDetailsOneToMany> createUser(@RequestBody UserDetailsOneToMany userDetails){
        return ResponseEntity.ok(
                this.oneToManyService.createUser(userDetails)
        );
    }

//    @GetMapping("/getUser/{userId}")
//    public ResponseEntity<UserDetailsOneToMany> getUserById(@PathVariable("userId") Long id){
//        return ResponseEntity.ok(
//                this.oneToManyService.getUserId(id)
//        );
//    }

    // Example to orphanRemoval
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserDetailsOneToMany> getUserById(@PathVariable("userId") Long id){
        UserDetailsOneToMany userDetailsOneToMany = this.oneToManyService.getUserId(id);
        userDetailsOneToMany.getOrders().removeFirst();
        oneToManyService.createUser(userDetailsOneToMany);
        return ResponseEntity.ok(userDetailsOneToMany);
    }

}
