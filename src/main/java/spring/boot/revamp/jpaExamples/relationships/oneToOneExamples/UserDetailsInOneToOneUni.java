package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details_one_to_one_uni")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsInOneToOneUni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

//    @OneToOne(cascade = CascadeType.ALL)
//    // override the hibernate behavior of selecting name and field by itself
//    @JoinColumn(name = "user_address",referencedColumnName = "city")
//    private UserAddressOneToOneUni userAddress;

    // For Composite key, we have to put @JoinColumn for all the fields making the Composite key
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city",referencedColumnName = "city")
    @JoinColumn(name = "address_pinCode",referencedColumnName = "pinCode")
    private UserAddressOneToOneUni userAddress;

}
