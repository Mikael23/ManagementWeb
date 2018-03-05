package management.ORM.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Trainer {



//    /trainers – получить список действующих тренеров
//    Response: trainers: {name, description, photo,
//            {массив name of the courses, которые ведет тренер + topic, к которому относится курс}}



    @JsonProperty("surname")
    public String surname;

    @OneToMany
    @JsonProperty("listOfCources")
    public List<Course>listOfCources;

    @JsonProperty("date")
    public Integer date;
    @JsonProperty("time")
    public Integer time;


    @JsonProperty("waitingList")
    public List<User>waitingLists;

    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;
//    @JsonProperty("courseId")
//    public Integer courseId;

    @Id
       @JsonProperty("id")
    public Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<User> getWaitingLists() {
        return waitingLists;
    }

    public void setWaitingLists(List<User> waitingLists) {
        this.waitingLists = waitingLists;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getListOfCources() {
        return listOfCources;
    }

    public void setListOfCources(List<Course> listOfCources) {
        this.listOfCources = listOfCources;
    }





    @JsonCreator
    public Trainer() {
    }
}







//    POST:
//            /admin/addtrainer - добавить тренера на страницу тренеров:
//    Body: {name, description, photo}
//    Response: 200 or 401
