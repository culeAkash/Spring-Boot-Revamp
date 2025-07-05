package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOneAddressRepository extends JpaRepository<UserAddressOneToOneUni,UserAddressOneToOneCK> {
}
