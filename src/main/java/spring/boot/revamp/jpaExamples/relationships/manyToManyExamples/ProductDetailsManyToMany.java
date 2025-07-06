package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_details_many_to_many")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDetailsManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private Double price;


    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<OrderDetailsManyToMany> orders = new ArrayList<>();
}
