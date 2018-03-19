package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingCancelledRequest {



    @JsonProperty
     public  Integer trainerId;
    @JsonProperty
    public String trainerName;
    @JsonProperty
    public String trainerSurname;
    @JsonProperty
    public String nameOfCourse;
    @JsonProperty
    public  Integer data;
    @JsonProperty
    public Integer time;
    @JsonProperty
    public String rejectmessage;

}

//
//
//
//
//
///userid/rejectrequests/ - слушать отклоненные тренером заявки
//        Response: как только появляется поле “rejectmessage”,
//        приходят поля: trainerid, trainer’s name, trainer’s surname, name of the course, date, time, rejectmessage.
