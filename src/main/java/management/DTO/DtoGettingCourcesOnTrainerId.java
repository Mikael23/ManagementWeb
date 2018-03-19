package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingCourcesOnTrainerId {


    public DtoGettingCourcesOnTrainerId() {
    }

    @JsonProperty
    public Integer courseId;
    @JsonProperty
    public String nameOfCourse;

    @JsonProperty
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }
}





//GET:
//        /trainerid/courses – при добавлении свободного времени (интервала) подгрузка курсов, которые ведет тренер
//        Response: courseid, name of the course (которые ведет тренер).
