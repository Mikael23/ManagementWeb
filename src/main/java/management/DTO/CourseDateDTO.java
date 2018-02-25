package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CourseDateDTO {
    @JsonProperty
    String date;
    @JsonProperty
    boolean busyness;
    @JsonProperty
    List<CourseTimeDTO> intervals;

    @JsonCreator
    public CourseDateDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getBusyness() {
        return busyness;
    }

    public void setBusyness(boolean busyness) {
        this.busyness = busyness;
    }

    public List<CourseTimeDTO> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<CourseTimeDTO> intervals) {
        this.intervals = intervals;
    }
}
