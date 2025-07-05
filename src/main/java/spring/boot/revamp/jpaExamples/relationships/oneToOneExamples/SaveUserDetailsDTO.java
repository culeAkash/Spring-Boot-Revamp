package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SaveUserDetailsDTO {
    private Long id;
    private String name;
    private String phone;
    private SaveAddressDTO addressDTO;
}


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
class SaveAddressDTO{

    private String street;
    private String state;
    private String city;
    private String pinCode;
}
