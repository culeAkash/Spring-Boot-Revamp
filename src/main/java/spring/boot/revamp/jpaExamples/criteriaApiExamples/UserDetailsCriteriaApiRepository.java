package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsCriteriaApiRepository extends JpaRepository<UserDetailsCriteriaApi,Long>, JpaSpecificationExecutor<UserDetailsCriteriaApi> {
}
