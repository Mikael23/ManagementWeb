package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetDates {

    @JsonProperty
   public String nameOfCourse;
    @JsonProperty
    public Integer data;
    @JsonProperty
    public Integer time;

    @JsonProperty
    public Integer trainerId;

    @JsonProperty
    public String trainerName;

    public GetDates() {
    }

    @JsonProperty

    public String trainerSurname;

    @JsonProperty
    public boolean status;


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

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}



//
//
//userid/”текущая дата, от которой будет выстраиваться месяц” – возвращает подтвержденные и неподтвержденные записи юзера на курсы.
//        Response: name of the course, date (относительно текущего месяца), time, trainerid, trainer’s name, trainer’s surname, confirmed.
//        Ниже кнопка «отменить запись».
