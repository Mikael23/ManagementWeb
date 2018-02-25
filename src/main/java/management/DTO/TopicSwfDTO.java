package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopicSwfDTO {
    @JsonProperty("topicName")
    String name;
    @JsonProperty("topicSwfLinc")
    String swfLinc;

    @JsonCreator
    public TopicSwfDTO() {

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
}
