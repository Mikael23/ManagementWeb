package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class Course {

    @JsonProperty("name")  public String name;
    @JsonProperty ("description") public String description;
    @JsonProperty("trainerName")  public String trainerName;




    public double[] getSuggestedData() {
        return SuggestedData;
    }

    public void setSuggestedData(double[] suggestedData) {
        this.SuggestedData = suggestedData;
    }



    public void setSuggestedTimes(double[] suggestedTimes) {
        this.SuggestedTimes = suggestedTimes;
    }

    @JsonProperty("quantatity") public Integer quantatity;
    @JsonProperty("id") public Integer id;

    public String getName() {
        return name;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserPhone() {

        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    @JsonProperty("coursename")
    public String Coursename;
    @JsonProperty("kindOfCourse")
    public String kindOfCourse;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("userName")
    public String userName;
    @JsonProperty("userPhone")
    public Integer userPhone;


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

    @JsonProperty("ChoosenData")
    public Double ChoosenData;


    @JsonProperty("ChoosenTime")
    public Double ChoosenTime;


    @JsonProperty("SuggestedTimes")
    public double [] SuggestedTimes = new double[2] ;

    @JsonProperty("SuggestedData")
    public double[] SuggestedData;



//    @JsonProperty("choosenCources")
//    List<Integer>choosenCorces;

}
