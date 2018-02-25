package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseNameTrainerDTO {
    @JsonProperty("name")
    public String name;

    @JsonProperty("trainerName")
    public String trainerName;

    @JsonCreator
    public CourseNameTrainerDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}
