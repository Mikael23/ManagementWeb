package management.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class ProposeCourse {

    @JsonProperty("coursename")
    public String Coursename;
    @JsonProperty("kindOfCourse")
    public String kindOfCourse;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("userName")
    public String userName;
    @JsonProperty("userPhone")
    public Integer userPhone;

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer idCourse;


    public ProposeCourse() {
    }

    public String CourseDescription;
    public Integer courseDuration;

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public String getKindOfCourse() {
        return kindOfCourse;
    }

    public void setKindOfCourse(String kindOfCourse) {
        this.kindOfCourse = kindOfCourse;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        CourseDescription = courseDescription;
    }

    public Integer getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Integer courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }


}

