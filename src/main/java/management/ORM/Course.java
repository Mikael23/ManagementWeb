package management.ORM;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Course {



    public List<Course> getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(List<Course> freeTimes) {
        this.freeTimes = freeTimes;
    }

    public List<Course> getFreeDates() {
        return freeDates;
    }

    public void setFreeDates(List<Course> freeDates) {
        this.freeDates = freeDates;
    }



    @JsonProperty("confirmed")
    boolean confirmed;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Users_Cources",
            joinColumns = { @JoinColumn(name = "course_name") },
            inverseJoinColumns = { @JoinColumn(name = "user_email") }
    )
    @JsonProperty
    public List<User> listOfUsers;


    @JsonProperty("massiveOfFreetimes")
    List<Course>freeTimes;

    @JsonProperty("massiveOfFreeDdates")
    List<Course>freeDates;

    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
    @Id
    @JsonProperty("trainerName")
    public String trainerName;
    @JsonProperty("ChoosenData")
    public Double ChoosenData;

    @JsonProperty("Duration")
    public Integer duration;
    @JsonProperty("ChoosenTime")
    public Double ChoosenTime;


    @JsonProperty("SuggestedTimes")
    public double[] SuggestedTimes = new double[2];

    @JsonProperty("SuggestedData")
    public double[] SuggestedData;
    @JsonProperty("coursename")
    public String Coursename;
    @JsonProperty("kindOfCourse")
    public String kindOfCourse;
    @JsonProperty("quantity")
    public Integer quantity;


    @JsonProperty("quantatity")
    public Integer quantatity;
    @JsonProperty("id")

    public Integer id;

    @ManyToOne
    @JsonProperty
    public Trainer trainer;

    public List<Course> getListOfRecords() {
        return listOfRecords;
    }

    public void setListOfRecords(List<Course> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    @JsonProperty("listOfRecords")
    List<Course>listOfRecords;


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public double[] getSuggestedData() {
        return SuggestedData;
    }

    public void setSuggestedData(double[] suggestedData) {
        this.SuggestedData = suggestedData;
    }


    public void setSuggestedTimes(double[] suggestedTimes) {
        this.SuggestedTimes = suggestedTimes;
    }


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
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
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


    public double[] getSuggestedTimes() {
        return SuggestedTimes;
    }

    public Double getChoosenTime() {
        return ChoosenTime;
    }

    public void setChoosenTime(Double choosenTime) {
        this.ChoosenTime = choosenTime;
    }


    public Double getChoosenData() {
        return ChoosenData;
    }

    public void setChoosenData(Double choosenData) {
        ChoosenData = choosenData;
    }


}
