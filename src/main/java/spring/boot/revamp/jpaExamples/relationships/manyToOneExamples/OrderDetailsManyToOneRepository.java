package spring.boot.revamp.jpaExamples.relationships.manyToOneExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsManyToOneRepository extends JpaRepository<OrderDetailsManyToOne,Long> {
}
