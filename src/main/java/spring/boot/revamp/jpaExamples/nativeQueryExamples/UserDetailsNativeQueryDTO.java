package spring.boot.revamp.jpaExamples.nativeQueryExamples;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class UserDetailsNativeQueryDTO {
    private String name;
    private String phone;
}
