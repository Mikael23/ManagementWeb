package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoCancellation {


    public DtoCancellation() {
    }

    @JsonProperty
    String trinerSurname;

    @JsonProperty
    String nameOfCourse;

    @JsonProperty
    Integer data;

    @JsonProperty
    Integer time;

    @JsonProperty
    String messageToUser;


    @JsonProperty
    Integer trainerid;

    @JsonProperty
    String trainerName;

    public Integer getTrainerid() {
        return trainerid;
    }

    public void setTrainerid(Integer trainerid) {
        this.trainerid = trainerid;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrinerSurname() {
        return trinerSurname;
    }

    public void setTrinerSurname(String trinerSurname) {
        this.trinerSurname = trinerSurname;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getMessageToUser() {
        return messageToUser;
    }

    public void setMessageToUser(String messageToUser) {
        this.messageToUser = messageToUser;
    }



}




