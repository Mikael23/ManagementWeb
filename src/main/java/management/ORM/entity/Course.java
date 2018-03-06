package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.List;

@Entity
@Table(name="Course")

public class Course implements Serializable {





   public boolean confirmed;

   @OneToOne
   public Schedule schedule;
//
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Users_Cources",
            joinColumns = { @JoinColumn(name = "Course_nameOfCourse") },
          inverseJoinColumns = { @JoinColumn(name = "user_email") }
   )
    @JsonProperty
    public List<User> listOfUsers;

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    @JsonProperty("name")
    public String name;


    @Column(name = "description")
    @JsonProperty("description")
    public String description;

    @JsonProperty("trainerName")
    public String trainerName;
//    @JsonProperty("ChoosenData")
//    public Double ChoosenData;

    @JsonProperty("Duration")
    public Integer duration;




    @JsonProperty("nameOfCourse")
    public String nameOfCourse;

    @JsonProperty("kindOfCourse")
    public String kindOfCourse;
    @JsonProperty("quantity")
    public Integer quantity;


    @JsonProperty("quantatity")
    public Integer quantatity;


    @Id
    @JsonProperty("id")
    public Integer id;

    @ManyToOne
    @JsonProperty
    public Trainer trainer;






    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

//    public List<User> getListOfUsers() {
//        return listOfUsers;
//    }
//
//    public void setListOfUsers(List<User> listOfUsers) {
//        this.listOfUsers = listOfUsers;
//    }



    public String getName() {
        return name;
    }

    @JsonCreator
    public Course() {
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

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }


    public Integer getQuantatity() {
        return quantatity;
    }

    public void setQuantatity(Integer quantatity) {
        this.quantatity = quantatity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return nameOfCourse;
    }

    public void setCoursename(String coursename) {
        this.nameOfCourse = coursename;
    }

    public String getKindOfCourse() {
        return kindOfCourse;
    }

    public void setKindOfCourse(String kindOfCourse) {
        this.kindOfCourse = kindOfCourse;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

//    public Integer getUserPhone() {
//
//        return userPhone;
//    }
//
//    public void setUserPhone(Integer userPhone) {
//        this.userPhone = userPhone;
//    }



}
