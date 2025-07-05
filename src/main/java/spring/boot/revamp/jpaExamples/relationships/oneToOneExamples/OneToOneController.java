package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jpaOneToOne")
public class OneToOneController {

    private final OneToOneService oneToOneService;

    public OneToOneController(OneToOneService oneToOneService){
        this.oneToOneService = oneToOneService;
    }

    @PostMapping("/createUser")
    public UserDetailsInOneToOneUni insertUser(@RequestBody SaveUserDetailsDTO userDetailsInOneToOneUni){
        return this.oneToOneService.saveUser(userDetailsInOneToOneUni);
    }

    @GetMapping("/getUser/{userId}")
    public SaveUserDetailsDTO findUserById(@PathVariable(name = "userId") Long id){
        return this.oneToOneService.findById(id);
    }
}
