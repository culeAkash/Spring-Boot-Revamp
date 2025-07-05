package spring.boot.revamp.jpaExamples.basicJpaExample;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

// To create a composite Primary Key,
/*
1. class must be public
2. must implement Serializable
3. override hashCode and equals method
4. non-params constructor must be present
*/

@Embeddable
@Getter
@Setter
public class UserDetailsCK implements Serializable {
    private String name;
    private String address;

    public UserDetailsCK(){}


    @Override
    public int hashCode() {
        return Objects.hash(name,address);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof UserDetailsCK userDetailsCK))
            return false;
        return (Objects.equals(this.address,userDetailsCK.address)) && (Objects.equals(this.name,userDetailsCK.name));
    }
}
