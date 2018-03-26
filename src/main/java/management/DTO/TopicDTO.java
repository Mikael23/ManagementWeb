package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import management.ORM.entity.Course;
import management.ORM.entity.TopicEntity;

import java.util.List;


public class TopicDTO extends TopicSwfDTO{


    @JsonProperty("coursesNames")
    List<String> namesOfCourses;


    @JsonProperty("topicImgLinc")
    String imgLinc;


    @JsonCreator
    public TopicDTO(){
    super();
    }


    public TopicDTO(List<String> namesOfCoursee, String imgLinc) {
        this.namesOfCourses = namesOfCoursee;
        this.imgLinc = imgLinc;
    }

    public TopicDTO(String name, String swfLinc, List<String> namesOfCoursee, String imgLinc) {
        super(name, swfLinc);
        this.namesOfCourses = namesOfCoursee;
        this.imgLinc = imgLinc;
    }

//    public TopicDTO(TopicEntity topicEntity, List<String> namesOfCoursee, String imgLinc) {
//        super(topicEntity);
//        this.namesOfCourses = namesOfCoursee;
//        this.imgLinc = imgLinc;
//    }

    public TopicDTO(TopicEntity topicEntity) {

        super(topicEntity.getName(), topicEntity.getLincSwf());

        this.imgLinc = topicEntity.getLincImg();

        for (Course course:
        topicEntity.getCourses()) {
            namesOfCourses.add(course.getName());
        };

    }





    public String getImgLinc() {
        return imgLinc;
    }
    public void setImgLinc(String imgLinc) {
        this.imgLinc = imgLinc;
    }

    public List<String> getNamesOfCourses() {
        return namesOfCourses;
    }

    public void setNamesOfCourses(List<String> namesOfCourses) {
        this.namesOfCourses = namesOfCourses;
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
