package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import management.ORM.entity.Course;
import management.ORM.entity.TopicEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TopicDTO {


    @JsonProperty("topicName")
    String name;
    @JsonProperty("topicSwfLinc")
    String swfLinc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSwfLinc() {
        return swfLinc;
    }

    public void setSwfLinc(String swfLinc) {
        this.swfLinc = swfLinc;
    }

    public TopicDTO(String name, String swfLinc, String[] namesOfCourses, String imgLinc) {
        this.name = name;
        this.swfLinc = swfLinc;
        this.courseNames = namesOfCourses;
        this.imgLinc = imgLinc;
    }

    public String[] getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(String[] courseNames) {
        this.courseNames = courseNames;
    }

    @JsonProperty("coursesNames")
    String[]courseNames;


    @JsonProperty("topicImgLinc")
    String imgLinc;


    @JsonCreator
    public TopicDTO(){

    }




    public TopicDTO(TopicEntity topicEntity) {


        this.name=topicEntity.getName();
        this.swfLinc=topicEntity.getLincSwf();

        this.imgLinc = topicEntity.getLincImg();

        for(int i =0; i<=topicEntity.getCourses().size()-1;i++){
            this.courseNames[i]=topicEntity.getCourses().get(i).nameOfCourse;
        }
    }





    public String getImgLinc() {
        return imgLinc;
    }
    public void setImgLinc(String imgLinc) {
        this.imgLinc = imgLinc;
    }





    @Override
    public String toString() {
        return "TopicDTO{" +
                "discription='" + '\'' +
                ", imgLinc='" + imgLinc + '\'' +
                ", name='" + name + '\'' +
                ", swfLinc='" + swfLinc + '\'' +
                '}';
    }
}
