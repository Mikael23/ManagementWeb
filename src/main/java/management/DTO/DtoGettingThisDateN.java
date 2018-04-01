package management.DTO;




///userid/”текущая дата, от которой будет выстраиваться месяц” – возвращает подтвержденные
//        и неподтвержденные записи юзера на курсы.
//        Response: name of the course, date (относительно текущего месяца),
//        time, trainerid, trainer’s name, trainer’s surname, confirmed(true or false)
//        Ниже кнопка «отменить запись».


import com.fasterxml.jackson.annotation.JsonProperty;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DtoGettingThisDateN {

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String surname;
    @JsonProperty
    public String nameOfCourse;
  public String dateTime;
    @JsonProperty public String trainerId;
    @JsonProperty public String trainerName;

    public DtoGettingThisDateN() {
    }

    @JsonProperty public  String trainerSurname;
    @JsonProperty public  boolean confirmationStatus;



}
