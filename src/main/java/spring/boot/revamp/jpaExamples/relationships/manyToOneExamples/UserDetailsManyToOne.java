package spring.boot.revamp.jpaExamples.relationships.manyToOneExamples;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_details_one_to_many")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class UserDetailsManyToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
}
