package spring.boot.revamp.jpaExamples.basicJpaExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/simpleJpa")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/test-jpa")
    public List<UserDetails> getUser(){
        UserDetails userDetails = new UserDetails(
                "xyz",
                "akash@gmail.com"
        );
        this.userDetailsService.saveUser(userDetails);
        return this.userDetailsService.getAllUsers();
    }
}
