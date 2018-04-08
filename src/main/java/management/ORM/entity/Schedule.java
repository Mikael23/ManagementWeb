package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.*;

@JsonSerialize
@Entity
@Table(name = "schedule")

public class Schedule implements Serializable {

   @Transient // ne kladem v bazu
   public String dateTime;


    public String data;

    public String[] getIntervals() {
        return intervals;
    }

    public void setIntervals(String[] intervals) {
        this.intervals = intervals;
    }

    public String[]intervals;

    public String trainerMessage;

    public String messageTOtrainer;

    @Column
    public String trainerName;

    public boolean confirmedByTrainer;// Odobreno li trenerom ili net:

    public String coursename;

    @GeneratedValue
    @Id
    public Integer id;

    public String requestedUser; // Imya zaprashimaemogo studenta;


    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @ElementCollection(targetClass = LocalDateTime.class)
    public List<LocalDateTime> dates = new LinkedList<>();


    @Column
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    public LocalDateTime dt;


    boolean busyness;

    public Integer date;

    public Trainer trainer;




    public boolean busy;


    @JsonCreator
    public Schedule() {
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

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public List<LocalDateTime> getDates() {
        return dates;
    }

    public void setDates(List<LocalDateTime> dates) {
        this.dates = dates;
    }
    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getTrainerMessage() {
        return trainerMessage;
    }

    public void setTrainerMessage(String trainerMessage) {
        this.trainerMessage = trainerMessage;
    }
    public String getCourse() {
        return coursename;
    }

    public void setCourse(String courseName) {
        this.coursename = courseName;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public boolean isConfirmedByTrainer() {
        return confirmedByTrainer;
    }

    public void setConfirmedByTrainer(boolean confirmedByTrainer) {
        this.confirmedByTrainer = confirmedByTrainer;
    }
    public String getMessageTOtrainer() {
        return messageTOtrainer;
    }

    public void setMessageTOtrainer(String messageTOtrainer) {
        this.messageTOtrainer = messageTOtrainer;
    }
    public String getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(String requestedUser) {
        this.requestedUser = requestedUser;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
