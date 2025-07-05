package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_address_one_to_one_uni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserAddressOneToOneUni {

    @EmbeddedId
    private UserAddressOneToOneCK id;

    private String street;
    private String state;

    // making bidirectional relation
    @OneToOne(mappedBy = "userAddress",fetch = FetchType.EAGER)
    private UserDetailsInOneToOneUni userDetailsInOneToOneUni;
}
