package spring.boot.revamp.jpaExamples.basicJpaExample.;

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
        UserDetailsCK userDetailsCK = new UserDetailsCK();
        userDetailsCK.setName("Akash");
        userDetailsCK.setAddress("Kolkata");
        UserDetails userDetails = UserDetails.builder()
                .email("akash@gmail.com")
                .phone("123456789")
                .userDetailsCK(
                        userDetailsCK
                )
                .build();
        UserDetails savedUser = this.userDetailsService.saveUser(userDetails);
//        this.userDetailsService.getAllUsers();
//         this.userDetailsService.getUserById(savedUser.getUserId());
        return null;
    }

    @GetMapping("/test-jpa2")
    public UserDetails getSingleUser(){
        this.userDetailsService.getUserById(1L);
        return this.userDetailsService.getUserById(1L).get();
    }

    @GetMapping("/test-jpa3")
    public UserDetails getSingleUser2(){
        this.userDetailsService.getUserById(1L);
        return this.userDetailsService.getUserById(1L).get();
    }
}
