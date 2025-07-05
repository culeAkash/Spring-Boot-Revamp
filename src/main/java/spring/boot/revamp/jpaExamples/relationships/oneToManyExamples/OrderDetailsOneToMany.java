package spring.boot.revamp.jpaExamples.relationships.oneToManyExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_details_one_to_many")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDetailsOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

}
