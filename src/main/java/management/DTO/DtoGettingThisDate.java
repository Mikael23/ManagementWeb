package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingThisDate {


    @JsonProperty

    Integer userId;
    @JsonProperty
    String userName;
    @JsonProperty
    String usersurname;
    @JsonProperty
    String[]NameOfcources;
    @JsonProperty
    Integer[]Freedate;
    @JsonProperty
    double[]freeTimes;


    @JsonProperty
    String NameOfCourse;

@JsonProperty
    Integer [] bysuDates;
@JsonProperty
    double[]busyTimes;

    public String getNameOfCourse() {
        return NameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        NameOfCourse = nameOfCourse;
    }

    public Integer[] getBysuDates() {
        return bysuDates;
    }

    public void setBysuDates(Integer[] bysuDates) {
        this.bysuDates = bysuDates;
    }

    public double[] getBusyTimes() {
        return busyTimes;
    }

    public void setBusyTimes(double[] busyTimes) {
        this.busyTimes = busyTimes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String[] getNameOfcources() {
        return NameOfcources;
    }

    public void setNameOfcources(String[] nameOfcources) {
        NameOfcources = nameOfcources;
    }

    public Integer[] getFreedate() {
        return Freedate;
    }

    public void setFreedate(Integer[] freedate) {
        Freedate = freedate;
    }

    public double[] getFreeTimes() {
        return freeTimes;
    }

    public void setFreeTimes(double[] freeTimes) {
        this.freeTimes = freeTimes;
    }



    public DtoGettingThisDate() {
    }
}


