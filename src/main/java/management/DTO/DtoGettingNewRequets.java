package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingNewRequets {

    @JsonProperty
    public Integer userid;
    @JsonProperty
    public String userName;
    @JsonProperty
    public String userSurname;

    @JsonProperty
    Integer time;

    @JsonProperty
    public Integer courseId;
    @JsonProperty
    public String NameOfCourse;
    @JsonProperty
    Integer date;

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


    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getNameOfCourse() {
        return NameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        NameOfCourse = nameOfCourse;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
    public DtoGettingNewRequets() {
    }



}


