package spring.boot.revamp.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


// only when dev profile is active this bean will be created
@Component
@Profile("dev")
public class ProfileSqlConnection {

    public ProfileSqlConnection(){
        System.out.println("ProfileSqlConnection object initialized");
    }
}
