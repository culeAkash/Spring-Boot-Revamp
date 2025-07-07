package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details_native_query")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
// for retrieving partial columns from the DB using a native query
@NamedNativeQuery(
        name = "UserDetails.getUserDetailsByName",
        query = "Select user_name,phone from user_details_native_query where user_name=:firstName",
        resultSetMapping = "UserDTOMapping"
)
@SqlResultSetMapping(
        name = "UserDTOMapping",
        classes = @ConstructorResult(
                targetClass = UserDetailsNativeQueryDTO.class,
                columns = {
                        @ColumnResult(name = "user_name",type = String.class),
                        @ColumnResult(name = "phone",type = String.class),
                }
        )
)
public class UserDetailsNativeQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_address_id",referencedColumnName = "addressId")
    private AddressNativeQuery address;
}
