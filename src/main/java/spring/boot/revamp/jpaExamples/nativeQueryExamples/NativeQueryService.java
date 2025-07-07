package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NativeQueryService {

    private final UserDetailsNativeQueryRepository userRepository;

    public NativeQueryService(UserDetailsNativeQueryRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDetailsNativeQuery> getUserExample1(String userFirstName){
        return this.userRepository.getUserDetailsByNameNativeQuery(userFirstName);
    }

    public List<UserDetailsNativeQueryDTO> runQuery2(String userName){
        return this.userRepository.getUserDetailsPartialFields(userName);
    }

    public void createUser(UserDetailsNativeQuery userDetailsNativeQuery){
        this.userRepository.save(userDetailsNativeQuery);
    }
}
