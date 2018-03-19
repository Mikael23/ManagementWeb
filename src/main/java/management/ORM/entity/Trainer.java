package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "trainer")

public class Trainer implements Serializable {

    @Id
    public String email;


    @JsonProperty("surname")
    public String surname;


    @ManyToMany
    public List<AllUsers> waitingLists;

    @JsonProperty("name")
    public String name;

    public String description;

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

    public String nameCourse;


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }



    @JsonProperty("photoLink")
    public String photoLink;



    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonProperty("listOfCources")
    public List<Course> listOfCources;




//    public Integer date;
//
//    public Integer time;


    public Integer idTrainer;

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

    public void setListOfCources(List<Course>listOfCources) {
        this.listOfCources = listOfCources;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }


    @JsonCreator
    public Trainer() {
    }
}






