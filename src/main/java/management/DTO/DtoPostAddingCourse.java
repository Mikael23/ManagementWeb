package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPostAddingCourse {

    @JsonProperty
    Integer courseId;
    @JsonProperty
    Integer trainerIdl;






    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTrainerIdl() {
        return trainerIdl;
    }

    public void setTrainerIdl(Integer trainerIdl) {
        this.trainerIdl = trainerIdl;
    }

    public DtoPostAddingCourse() {
    }
}




//POST:
//        /admin/addcourse - добавить course и привязать его к тренеру:
//        Body: {courseid, name of the course, description, trainerid, duration, quantity (максимальное количество записей на сессию),
//        confirmed = true}
//        Response: courseid связать с trainerid , поля yourname и phone удалить, поле confirmed поменять на true.
//        Ошибка может быть в случае, если такой courseid уже существует.
//






