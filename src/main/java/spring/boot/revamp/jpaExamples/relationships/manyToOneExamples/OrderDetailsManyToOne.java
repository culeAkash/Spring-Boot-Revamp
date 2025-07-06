package spring.boot.revamp.jpaExamples.relationships.manyToOneExamples;

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
public class OrderDetailsManyToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;


    // Many to One mapping in unidirectional manner, now FK creation is in the hands of child
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk_own_id",referencedColumnName = "id")
    private UserDetailsManyToOne userDetails;

}
