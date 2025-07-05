package spring.boot.revamp.jpaExamples.relationships.oneToOneExamples;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserAddressOneToOneCK implements Serializable {

    private String city;
    private String pinCode;

    public UserAddressOneToOneCK(){}

    @Override
    public int hashCode() {
        return Objects.hash(city,pinCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof UserAddressOneToOneCK userAddressOneToOneCK))return false;
        return Objects.equals(this.city, userAddressOneToOneCK.city) && Objects.equals(this.pinCode, userAddressOneToOneCK.pinCode);
    }
}
