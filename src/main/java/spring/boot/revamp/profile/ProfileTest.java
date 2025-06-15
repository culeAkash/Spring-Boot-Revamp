package spring.boot.revamp.profile;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfileTest {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public ProfileTest(){
        System.out.println("ProfileTest object initialized");
    }

    @PostConstruct
    public void init(){
        System.out.println("Username: " + username + " and password: " + password);
    }
}
