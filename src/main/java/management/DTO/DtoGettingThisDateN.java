package management.DTO;




///userid/”текущая дата, от которой будет выстраиваться месяц” – возвращает подтвержденные
//        и неподтвержденные записи юзера на курсы.
//        Response: name of the course, date (относительно текущего месяца),
//        time, trainerid, trainer’s name, trainer’s surname, confirmed(true or false)
//        Ниже кнопка «отменить запись».


import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingThisDateN {
    @JsonProperty
    public String nameOfCourse;
    @JsonProperty Integer date;
    @JsonProperty Integer time;
    @JsonProperty Integer trainerId;
    @JsonProperty String trainerName;

    public DtoGettingThisDateN() {
    }

    @JsonProperty String trainerSurname;
    @JsonProperty boolean confirmationStatus;

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

    public boolean isConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(boolean confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }


}
