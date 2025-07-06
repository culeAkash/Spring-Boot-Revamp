package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsManyToManyRepository extends JpaRepository<ProductDetailsManyToMany,Long> {
}
