package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public String getSwfLinc() {
        return swfLinc;
    }
    public void setSwfLinc(String swfLinc) {
        this.swfLinc = swfLinc;
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
}
