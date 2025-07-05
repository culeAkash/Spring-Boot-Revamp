package spring.boot.revamp.jpaExamples.relationships.oneToManyExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsOneToManyRepository extends JpaRepository<UserDetailsOneToMany,Long> {
}
