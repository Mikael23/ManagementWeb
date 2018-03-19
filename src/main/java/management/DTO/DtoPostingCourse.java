package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPostingCourse {


@JsonProperty


public String message;

    public DtoPostingCourse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
