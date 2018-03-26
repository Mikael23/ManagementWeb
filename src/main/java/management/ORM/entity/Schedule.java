package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "schedule")

public class Schedule implements Serializable {

   @Transient // ne kladem v bazu
   public String dateTime;


    public String getMessageTOtrainer() {
        return messageTOtrainer;
    }

    public void setMessageTOtrainer(String messageTOtrainer) {
        this.messageTOtrainer = messageTOtrainer;
    }

    public String messageTOtrainer;

    @Column
    public String trainerName;

   public boolean confirmedByTrainer;// Odobreno li trenerom ili net:

    public boolean isConfirmedByTrainer() {
        return confirmedByTrainer;
    }

    public void setConfirmedByTrainer(boolean confirmedByTrainer) {
        this.confirmedByTrainer = confirmedByTrainer;
    }

    public String coursename;


    @GeneratedValue
    @Id
    public Integer id;


    public String getRequestedUser() {
        return requestedUser;
    }

    public void setRequestedUser(String requestedUser) {
        this.requestedUser = requestedUser;
    }

    public String requestedUser; // Imya zaprashimaemogo studenta;


    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @ElementCollection(targetClass = LocalDateTime.class)
    public List<LocalDateTime> dates = new LinkedList<>();


    @Column
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    public LocalDateTime dt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String data;
    boolean busyness;









    public Integer date;

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

    public Trainer trainer;


    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

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
}
