package spring.boot.revamp.jpaExamples.relationships.oneToManyExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsOneToManyRepository extends JpaRepository<OrderDetailsOneToMany,Long> {
}
