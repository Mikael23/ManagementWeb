package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseResponse {


   public Course course;


    @JsonProperty("quantity")
    public Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("userName")
    public String userName;

}
