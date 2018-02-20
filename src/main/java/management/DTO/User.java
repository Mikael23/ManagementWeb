package management.DTO;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.text.DateFormat;

@Entity
public class User {

//
//    Body: {user: {name, surname, email, password, repeatpassword, phone, dateofbirth,
//            city – заполнение всех полей обязательно; skype, viber, whatsapp, telegram, vk, facebook, instagram – не обязательно
//


    @JsonProperty("name") public  String name;
  @JsonProperty("surname")  public String surname;
  @JsonProperty("email")   public String email;
  @JsonProperty("password") public String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("role")public String role;





    @JsonCreator
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumPhone() {
        return NumPhone;
    }

    public void setNumPhone(int numPhone) {
        NumPhone = numPhone;
    }

    public DateFormat getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateFormat dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int NumPhone;
    public DateFormat dateOfBirth;









}
