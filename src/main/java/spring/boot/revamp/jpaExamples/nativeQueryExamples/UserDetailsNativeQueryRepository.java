package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsNativeQueryRepository extends JpaRepository<UserDetailsNativeQuery,Long> {

    @Query(value = "Select * from user_details_native_query where user_name=:firstName",nativeQuery = true)
    List<UserDetailsNativeQuery> getUserDetailsByNameNativeQuery(@Param("firstName") String userName);

    @Query(name = "UserDetails.getUserDetailsByName",nativeQuery = true)
    List<UserDetailsNativeQueryDTO> getUserDetailsPartialFields(@Param("firstName") String name);
}
