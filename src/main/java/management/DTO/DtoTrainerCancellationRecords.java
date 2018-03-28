package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import java.time.LocalDateTime;


public class DtoTrainerCancellationRecords {

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }


    public String localDateTime;
    @JsonProperty
    public Integer UserId;
    @JsonProperty
    public String UserName;
    @JsonProperty
    public String UserSurname;
    @JsonProperty
    public String NameOfCourse;

    @JsonProperty
    public String messagetotrainer;
//
//    public Integer getUserId() {
//        return UserId;
//    }
//
//    public void setUserId(Integer userId) {
//        UserId = userId;
//    }
//
//    public String getUserName() {
//        return UserName;
//    }
//
//    public void setUserName(String userName) {
//        UserName = userName;
//    }
//
//    public String getUserSurname() {
//        return UserSurname;
//    }
//
//    public void setUserSurname(String userSurname) {
//        UserSurname = userSurname;
//    }
//
//    public String getNameOfCourse() {
//        return NameOfCourse;
//    }
//
//    public void setNameOfCourse(String nameOfCourse) {
//        NameOfCourse = nameOfCourse;
//    }


    public DtoTrainerCancellationRecords() {
    }

//
//    public String getMessagetotrainer() {
//        return messagetotrainer;
//    }
//
//    public void setMessagetotrainer(String messagetotrainer) {
//        this.messagetotrainer = messagetotrainer;
//    }
}



//
//
//
///trainerid/cancelledtime – слушать отмененные записи
//        Response: как только появляется поле “messagetotrainer”, приходят поля: userid, user’s name,
//        user’s surname, name of the course, date, time, messagetotrainer.
//
