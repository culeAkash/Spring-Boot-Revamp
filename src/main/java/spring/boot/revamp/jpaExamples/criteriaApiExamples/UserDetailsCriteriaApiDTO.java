package spring.boot.revamp.jpaExamples.criteriaApiExamples;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class UserDetailsCriteriaApiDTO {
    private String name;
    private String phone;
}
