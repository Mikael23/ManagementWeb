package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "course")

public class Course implements Serializable {


    //  @ManyToOne
    //private Topic topic;
    public String phoneInitiator;

    public String initiatorCourse;


    public boolean confirmed;

    @OneToOne
    public Schedule schedule;
    //


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Users_Cources",
            joinColumns = {@JoinColumn(name = "Course_nameOfCourse")},
            inverseJoinColumns = {@JoinColumn(name = "user_email")}
    )

    public List<AllUsers> listOfAllUsers;


    public String name;


    @Column(name = "description")
    public String description;

    public String trainerName;


    public Integer duration;


    @Id
    public String nameOfCourse;

    public String kindOfCourse;
    // @JsonProperty("quantity")
    public Integer quantity;


    //@JsonProperty("quantatity")
    public Integer quantatity;


    // @JsonProperty("id")
    public Integer id;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonProperty
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Trainer trainer;


//    public List<AllUsers> getListOfAllUsers() {
//        return listOfAllUsers;
//    }
//
//    public void setListOfAllUsers(List<AllUsers> listOfAllUsers) {
//        this.listOfAllUsers = listOfAllUsers;
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

    public String getInitiatorCourse() {
        return initiatorCourse;
    }

    public void setInitiatorCourse(String initiatorCourse) {
        this.initiatorCourse = initiatorCourse;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhoneInitiator() {
        return phoneInitiator;
    }

    public void setPhoneInitiator(String phoneInitiator) {
        this.phoneInitiator = phoneInitiator;
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
    public List<AllUsers> getListOfAllUsers() {
        return listOfAllUsers;
    }

    public void setListOfAllUsers(List<AllUsers> listOfAllUsers) {
        this.listOfAllUsers = listOfAllUsers;
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }


}
