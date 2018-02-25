package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import management.testData.Topic;

import java.util.List;

public class TopicDTO extends TopicSwfDTO{
//    @JsonProperty("topicName")
//    String name;
    @JsonProperty("topicDiscription")
    String discription;
//    @JsonProperty("topicSwfLinc")
//    String swfLinc;
    @JsonProperty("topicImgLinc")
    String imgLinc;
//	@JsonProperty("coursesNames")
//	List<CourseNameTrainer> coursesNames;

    @JsonCreator
    public TopicDTO(){
    super();
    }



    public TopicDTO(String name, String swfLinc, String discription, String imgLinc) {
        super(name, swfLinc);
        this.discription = discription;
        this.imgLinc = imgLinc;
    }

    public static TopicDTO refactorTopic(Topic topic){
        String name = topic.getName();
        String discription = topic.getDiscription();
        String swfLinc = topic.getSwfLinc();
        String imgLinc = topic.getImgLinc();
        return new TopicDTO(name, swfLinc, discription, imgLinc);
    }


    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getImgLinc() {
        return imgLinc;
    }
    public void setImgLinc(String imgLinc) {
        this.imgLinc = imgLinc;
    }
//	public List<CourseNameTrainer> getCoursesNames() {
//		return coursesNames;
//	}
//	public void setcoursesNames(List<CourseNameTrainer> coursesNames) {
//		this.coursesNames = coursesNames;
//	}


    @Override
    public String toString() {
        return "TopicDTO{" +
                "discription='" + discription + '\'' +
                ", imgLinc='" + imgLinc + '\'' +
                ", name='" + name + '\'' +
                ", swfLinc='" + swfLinc + '\'' +
                '}';
    }
}
