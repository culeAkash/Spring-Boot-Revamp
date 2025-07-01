package spring.boot.revamp.jpaExamples.basicJpaExample;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
    }

    public void saveUser(UserDetails userDetails){
        this.userDetailsRepository.save(userDetails);
    }

    public List<UserDetails> getAllUsers(){
        return this.userDetailsRepository.findAll();
    }
}
