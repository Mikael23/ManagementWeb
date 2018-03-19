package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import management.ORM.entity.Course;

import java.util.List;

public class DtoGettingConfirmedRequests {

///trainerid/”текущая дата, от которой будет выстраиваться неделя” – возвращает подтвержденные заявки,
//    фильтрация по confirmed=true, и свободные интервалы (фильтрация по busy = false)
//    Response: подтвержденные заявки: name of the course, date (относительно текущего дня + неделя),
//    time, userid, user’s name, user’s surname. свободные интервалы: name of the course
//            (массив курсов, которые гипотетически будут проводиться в этот интервал времени), date, time.



    @JsonProperty
    Integer date;
    @JsonProperty
    Integer time;
    @JsonProperty
    Integer userId;
    @JsonProperty
    String userName;
    @JsonProperty
    String userSurname;

    @JsonProperty
    List<Course>cources;

    public DtoGettingConfirmedRequests() {
    }

    @JsonProperty
String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
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


}










