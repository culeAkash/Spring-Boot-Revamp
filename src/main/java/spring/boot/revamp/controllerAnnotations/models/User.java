package spring.boot.revamp.controllerAnnotations.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty(value = "user_name")
    private String username;
    private String email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
