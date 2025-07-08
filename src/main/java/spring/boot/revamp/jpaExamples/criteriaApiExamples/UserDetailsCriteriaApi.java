package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details_criteria_api")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDetailsCriteriaApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_address_id",referencedColumnName = "addressId")
    private AddressCriteriaApi address;
}
