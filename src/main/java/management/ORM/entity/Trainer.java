package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "trainer")

public class Trainer implements Serializable {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer id;

    @Id
    @JsonProperty("email")

    public String email;

    @JsonProperty("surname")
    public String surname;

    @ManyToMany
    public List<AllUsers> waitingLists;

    @JsonProperty("name")
    public String name;

    public String description;

    public String nameCourse;

    @JsonProperty("photoLink")
    public String photoLink;

    public Integer idTrainer;


    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("listOfCources")
    public List<Course> listOfCources;








//    Если все успешно, данные дата и время попадают в неподтвержденные записи у тренера,

//    public Integer date;
//
//    public Integer time;


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;


//    public Integer getDate() {
//        return date;
//    }
//
//    public void setDate(Integer date) {
//        this.date = date;
//    }
//
//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }

    public List<AllUsers> getWaitingLists() {
        return waitingLists;
    }

    public void setWaitingLists(List<AllUsers> waitingLists) {
        this.waitingLists = waitingLists;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getListOfCources() {
        return listOfCources;
    }

    public void setListOfCources(List<Course> listOfCources) {
        this.listOfCources = listOfCources;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }


    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Integer getIdTrainer() {
        return idTrainer;
    }

    public void setIdTrainer(Integer idTrainer) {
        this.idTrainer = idTrainer;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    @JsonCreator
    public Trainer() {
    }
}






