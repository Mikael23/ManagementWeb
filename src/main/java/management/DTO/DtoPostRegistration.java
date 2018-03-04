package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPostRegistration {


    @JsonProperty
    public Integer UserId;
    public String role;

    public DtoPostRegistration() {
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
