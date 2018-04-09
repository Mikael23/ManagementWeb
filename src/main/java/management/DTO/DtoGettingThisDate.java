package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingThisDate {


    public String busyTime;

    @JsonProperty

    public String userId;
    @JsonProperty
    public String userName;
    @JsonProperty
    public String usersurname;
    @JsonProperty
    public String NameOfcources;

    public String freeTimes;


    public boolean confirmed;

    public boolean busy;




    public DtoGettingThisDate() {
    }
}


///trainerid/”текущая дата, от которой будет выстраиваться неделя” – возвращает подтвержденные заявки,
//        фильтрация по confirmed=true, и свободные интервалы (фильтрация по busy = false)
//        Response: подтвержденные заявки: name of the course, date (относительно текущего дня + неделя),
//        time, userid, user’s name, user’s surname. свободные интервалы: name of the course
//        (массив курсов, которые гипотетически будут проводиться в этот интервал времени), date, time. Vozvrashau and confirmed and free intervals
//        PUT:
