package management.DTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersCourseDTO {
    @JsonProperty("courseid")
    Integer courseId;
    @JsonProperty("userid")
    Integer UserId;
    @JsonProperty("chosendate")
    String chosenDate;
    @JsonProperty("chosentime")
    String chosenTime;
    @JsonProperty("note")
    String usersNote;
    @JsonProperty("confirmed")
    boolean confirmed;

    @JsonCreator
    public UsersCourseDTO() {

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getChosenDate() {
        return chosenDate;
    }

    public void setChosenDate(String chosenDate) {
        this.chosenDate = chosenDate;
    }

    public String getChosenTime() {
        return chosenTime;
    }

    public void setChosenTime(String chosenTime) {
        this.chosenTime = chosenTime;
    }

    public String getUsersNote() {
        return usersNote;
    }

    public void setUsersNote(String usersNote) {
        this.usersNote = usersNote;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
