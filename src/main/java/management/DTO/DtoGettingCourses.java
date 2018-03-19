package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingCourses {


    @JsonProperty
   public Integer courseId;
    @JsonProperty
    public String nameOfCourse;
    @JsonProperty
    public String description;
    @JsonProperty
    public String trainerId;
    @JsonProperty
    public Integer duration;
    @JsonProperty
    public Integer quantity;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public DtoGettingCourses() {
    }


    //    /admin/courses – подгрузка всех существующих курсов и их параметров (фильтрация по confirmed = true)
//    Response: { courseid, name of the course, description, trainerid, duration, quantity }

}
