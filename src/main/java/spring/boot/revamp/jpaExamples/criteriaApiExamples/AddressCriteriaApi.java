package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_address_criteria_api")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AddressCriteriaApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String city;
    private String street;

}
