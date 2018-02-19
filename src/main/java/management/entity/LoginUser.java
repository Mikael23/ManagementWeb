package management.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;


@Entity
public class LoginUser {


    @JsonProperty("email")   public String email;
    @JsonProperty("password") public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginUser() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
