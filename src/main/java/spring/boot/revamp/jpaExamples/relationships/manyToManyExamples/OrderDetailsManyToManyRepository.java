package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsManyToManyRepository extends JpaRepository<OrderDetailsManyToMany,Long> {
}
