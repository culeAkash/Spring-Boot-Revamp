package spring.boot.revamp.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProfileNoSqlConnection {

    public ProfileNoSqlConnection(){
        System.out.println("ProfileNoSqlConnection object initialized");
    }
}
