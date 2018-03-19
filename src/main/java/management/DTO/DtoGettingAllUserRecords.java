package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingAllUserRecords {
    @JsonProperty
    Integer time;
    @JsonProperty
    Integer trainerId;
    @JsonProperty
    String trainerName;
    @JsonProperty
    String trainerSurname;
    @JsonProperty
    boolean confirmed;


    @JsonProperty
    String nameOfCourse;

    @JsonProperty
    Integer date;

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public DtoGettingAllUserRecords() {
    }


//
//    /userid/”текущая дата, от которой будет выстраиваться месяц” – возвращает подтвержденные
//    и неподтвержденные записи юзера на курсы.
//    Response: name of the course, date (относительно текущего месяца), time, trainerid,
//    trainer’s name, trainer’s surname, confirmed.
//    Ниже кнопка «отменить запись».


}
