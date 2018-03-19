package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DtoGettingWaitingList {

@JsonProperty
    public Integer userId;
@JsonProperty
    public String userName;
@JsonProperty
    public String userSurname;
@JsonProperty
    public String nameOfCourse;


    public List<String> getListOfUserNames() {
        return listOfUserNames;
    }

    public void setListOfUserNames(List<String> listOfUserNames) {
        this.listOfUserNames = listOfUserNames;
    }

    @JsonProperty
    List<String>listOfUserNames;

    public Integer getUserId() {
        return userId;
    }

    public DtoGettingWaitingList() {
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }
}
//GET:
//        /trainerid/waitinglist – лист ожидания, слушать по параметру «waiting»
//        Response: userid, user’s name, user’s surname, name of the course - пользователи,
//        которые пытались записаться на конкретный курс этого тренера, но не нашли свободное время для сеанса.
