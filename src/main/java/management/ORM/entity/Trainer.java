package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Trainer")

public class Trainer extends User implements Serializable {

    @Id
    public String email;

    @JsonProperty("surname")
    public String surname;


    @ManyToMany
    public List<User> waitingLists;

    @JsonProperty("name")
    public String name;

    public String description;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String photoLink;


    @OneToMany
    @JsonProperty("listOfCources")
    public List<Course> listOfCources;

//    public Integer date;
//
//    public Integer time;


    public Integer id;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<User> getWaitingLists() {
        return waitingLists;
    }

    public void setWaitingLists(List<User> waitingLists) {
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


    @JsonCreator
    public Trainer() {
    }
}






