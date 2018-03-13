package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingProposedCourse {


    @JsonProperty
    public Integer duration;
    @JsonProperty
    public Integer quantity;
    @JsonProperty
    public String yourname;
    @JsonProperty
    public String phone;
    @JsonProperty
   public Integer courseId;
    @JsonProperty
  public  String nameOfCourse;
    @JsonProperty
   public String description;

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

    public String getYourname() {
        return yourname;
    }

    public void setYourname(String yourname) {
        this.yourname = yourname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public DtoGettingProposedCourse() {
    }
}








//GET:
//        /admin/proposedcourses – получение новых заявок на новые курсы, фильтруется по параметру confirmed = false
//        Response: {courseid (если уже сформирован), name of the course, description, duration,
//        (длительность сессии), quantity (максимальное количество записей на сессию), yourname, phone }
