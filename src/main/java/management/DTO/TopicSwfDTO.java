package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import management.testData.Topic;

public class TopicSwfDTO {
    @JsonProperty("topicName")
    String name;
    @JsonProperty("topicSwfLinc")
    String swfLinc;

    @JsonCreator
    public TopicSwfDTO() {

    }

    public TopicSwfDTO(String name, String swfLinc) {
        this.name = name;
        this.swfLinc = swfLinc;
    }

    public static TopicSwfDTO refactorTopic(Topic topic){
        String name = topic.getName();
        String swfLinc = topic.getSwfLinc();

        return new TopicSwfDTO(name, swfLinc);
    }

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

    @Override
    public String toString() {
        return "TopicSwfDTO{" +
                "name='" + name + '\'' +
                ", swfLinc='" + swfLinc + '\'' +
                '}';
    }
}
