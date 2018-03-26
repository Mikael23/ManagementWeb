package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import java.time.LocalDateTime;

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

    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)

    public LocalDateTime localDateTime;



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


