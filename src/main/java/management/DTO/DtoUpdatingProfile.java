package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoUpdatingProfile {

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

    public String email;

    @JsonProperty
    public String name;
@JsonProperty
    public String surname;

    public Integer getNumberOfMistake() {
        return numberOfMistake;
    }

    public void setNumberOfMistake(Integer numberOfMistake) {
        this.numberOfMistake = numberOfMistake;
    }

    @JsonProperty
public Integer numberOfMistake;


    public DtoUpdatingProfile() {
    }
}



//
//PUT: - кнопка «редактировать личные данные»
//        /userid/update – обновляет информацию профиля пользователя
//        Body: {name, surname, old password, new password, repeat
//        new password, phone, city, skype, viber, whatsapp, telegram, vk, facebook, instagram }
//        Response: name, surname, 200 or 401
