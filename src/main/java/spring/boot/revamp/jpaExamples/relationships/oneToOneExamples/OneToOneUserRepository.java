package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOneUserRepository extends JpaRepository<UserDetailsInOneToOneUni,Long> {
}
