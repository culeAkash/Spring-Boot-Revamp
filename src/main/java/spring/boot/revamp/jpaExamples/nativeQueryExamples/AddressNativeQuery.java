package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AddressNativeQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String city;
    private String street;

}
