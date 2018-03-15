package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;



import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.List;



@Entity
@Table(name="schedule")

public class Schedule implements Serializable {


    boolean confirmed;
    boolean busyness;



    @Id
    public Integer courseId;
    public Integer UserId;
    public Integer date;



    @ElementCollection(targetClass=Integer.class)
    public  List<Integer> datesTimes;



    public List<Integer> getDatesTimes() {
        return datesTimes;
    }

    public void setDatesTimes(List<Integer> datesTimes) {
        this.datesTimes = datesTimes;
    }




    @JsonCreator
    public Schedule() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isBusyness() {
        return busyness;
    }

    public void setBusyness(boolean busyness) {
        this.busyness = busyness;
    }


}
