package spring.boot.revamp.jpaExamples.relationships.oneToManyExamples;

import org.springframework.stereotype.Service;

@Service
public class OneToManyService {

    private final UserDetailsOneToManyRepository userRepository;

    public OneToManyService(UserDetailsOneToManyRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDetailsOneToMany createUser(UserDetailsOneToMany userDetailsOneToMany){
        return this.userRepository.save(userDetailsOneToMany);
    }

    public UserDetailsOneToMany getUserId(Long id){
        return this.userRepository.findById(id).orElse(null);
    }
}
