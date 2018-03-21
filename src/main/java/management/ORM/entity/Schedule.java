package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name="schedule")

public class Schedule implements Serializable {


//    boolean confirmed;

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(List<LocalDateTime> dates) {
        this.dates = dates;
    }

    @Transient
    public String trainername;

    public String courseName;


    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    @Column
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)

    public List<LocalDateTime>dates;

    @Column
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime dt;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String data;
    boolean busyness;



    @Id
   // public String courseName;

    public Integer UserId;

    public Integer date;

    public String getCourse() {
        return courseName;
    }

    public void setCourse(String courseName) {
        this.courseName = courseName;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer trainer;



    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean busy;




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



    public boolean isBusyness() {
        return busyness;
    }

    public void setBusyness(boolean busyness) {
        this.busyness = busyness;
    }


}
