package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/criteriaApiJpa")
public class CriteriaApiController {

    private final CriteriaApiService criteriaApiService;

    public CriteriaApiController(CriteriaApiService criteriaApiService ){
        this.criteriaApiService = criteriaApiService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Void> createUser(@RequestBody UserDetailsCriteriaApi userDetailsCriteriaApi){
        this.criteriaApiService.saveUser(userDetailsCriteriaApi);
        return ResponseEntity.accepted().build();
    }


    @GetMapping("/user/{phone}")
    public List<UserDetailsCriteriaApi> getUserDetailsByPhoneCriteriaApi(@PathVariable String phone){
        return this.criteriaApiService.getUserDetailsByPhoneCriteriaApi(phone);
    }

    @GetMapping("/user/multi/{phone}")
    public List<UserDetailsCriteriaApiDTO> getUserDetailsByPhoneCriteriaApiMulti(@PathVariable String phone){
        return this.criteriaApiService.getUserDetailsByPhoneCriteriaApiMultiSelect(phone);
    }


    @GetMapping("/user/sort/{phone}")
    public List<Object[]> getUserDetailsByPhoneCriteriaApiSorting(@PathVariable String phone){
        return this.criteriaApiService.getUserDetailsByPhoneCriteriaApiPaginationAndSorting(phone);
    }

    @GetMapping("/user/spec/{phone}")
    public List<UserDetailsCriteriaApi> getUserDetailsByPhoneSpec(@PathVariable String phone){
        return this.criteriaApiService.getUserDetailsSpecApi(phone);
    }

}
