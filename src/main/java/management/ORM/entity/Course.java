package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")

public class Course implements Serializable {


    //  @ManyToOne
    //private Topic topic;
    public String phoneInitiator;

    public String initiatorCourse;

    @Transient
    LocalDateTime UserChoosenTime;



    public boolean confirmed;

    public boolean isTimeConfirmedForUser() {
        return timeConfirmedForUser;
    }

    public void setTimeConfirmedForUser(boolean timeConfirmedForUser) {
        this.timeConfirmedForUser = timeConfirmedForUser;
    }


    public boolean timeConfirmedForUser;

//    @OneToOne
//    public Schedule schedule;
    //


    @ManyToMany(fetch = FetchType.LAZY)
    public Set<AllUsers> listOfAllUsers = new HashSet<AllUsers>();


    public String name;


    @Column(name = "description")
    public String description;

    public String trainerName;


    public Integer duration;


    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    @Id
    public String nameOfCourse;


    


    //@JsonProperty("quantatity")
    public Integer quantity;


    @GeneratedValue
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
    public Set<AllUsers> getListOfAllUsers() {
        return listOfAllUsers;
    }

    public void setListOfAllUsers(Set<AllUsers> listOfAllUsers) {
        this.listOfAllUsers = listOfAllUsers;
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }


}
