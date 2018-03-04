package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoCancellingUserTime {

    @JsonProperty
    public Integer time;


    @JsonProperty
    public String messageToUser;
    @JsonProperty
    public Integer trainerId;
    @JsonProperty
    public String nameOfCourse;
    @JsonProperty
    public Integer date;

    public String getMessageToUser() {
        return messageToUser;
    }

    public void setMessageToUser(String messageToUser) {
        this.messageToUser = messageToUser;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

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

    public DtoCancellingUserTime() {
    }
}





///trainerid/cancelusertime - удаление заявки, освобождаем время. При нажатии вылезает форма «указать причину» (messagetouser).
//        Body: {userid, courseid, date, time, messagetouser, busy = false, confirmed = false }
//        Response: проверка по данным на наличие записи на это время на этот курс этого юзера.
//        Если все ок, отправка сообщения на email userid, c данными: trainerid, name of the course,
//        date, time, messagetouser. date-time снова становятся свободными: поле busy меняется на false, confirmed меняется на false.
