package spring.boot.revamp.jpaExamples.relationships.manyToManyExamples;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_details_many_to_many")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDetailsManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),// foreign key for order
            inverseJoinColumns = @JoinColumn(name = "product_id") // foreign key for product
    )
    private List<ProductDetailsManyToMany> products = new ArrayList<>();
}
