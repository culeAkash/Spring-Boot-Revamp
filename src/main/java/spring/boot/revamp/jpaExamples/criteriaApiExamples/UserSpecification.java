package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<UserDetailsCriteriaApi> equalsPhone(String phone){
        return (user,criteriaQuery,criteriaBuilder) ->
                criteriaBuilder.equal(user.get("phone"),phone);
    }


    public static Specification<UserDetailsCriteriaApi> likeName(String name){
        return (user,criteriaQuery,criteriaBuilder) ->
                criteriaBuilder.like(user.get("name"),"%" + name + "%");
    }

    public static Specification<UserDetailsCriteriaApi> joinAddress(){
        return (user,criteriaQuery,criteriaBuilder) ->{
            user.join("address",JoinType.INNER);
            return null;
        };
    }
}
