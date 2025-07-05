package spring.boot.revamp.jpaExamples.basicJpaExample;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "App_User",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name","email"})
        },
        indexes = {
                @Index(name = "index_name_email",columnList = "name,email")
        }
)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "userDetailsCache")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDetails {
    private Long userId;
    private String email;
    private String phone;

    @EmbeddedId
    private UserDetailsCK userDetailsCK;

}
