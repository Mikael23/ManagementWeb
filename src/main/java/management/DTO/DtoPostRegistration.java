package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPostRegistration {


    @JsonProperty
    public String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String login;

    public DtoPostRegistration() {
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    //    Response: назначить id юзеру – userid, направление на страницу, с которой
//    был запуск регистрации, назначить role – по умолчанию всегда user
//            (на trainer может изменить администратор).



}
