package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseDateAndTimesResponse {

    @JsonProperty("trainerName")
    public String trainerName;
    @JsonProperty("duration")
    public double [] suggestedTimes = new double[2] ;
    @JsonProperty("name")  public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseDateAndTimesResponse(String trainerName, double[] suggestedTimes, Integer quantity, String name) {
        this.trainerName = trainerName;
        this.suggestedTimes = suggestedTimes;
        this.quantity = quantity;
        this.name = name;
    }

    @JsonProperty("quantity")

    public Integer quantity;

    public CourseDateAndTimesResponse() {
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public double[] getSuggestedTimes() {
        return suggestedTimes;
    }

    public void setSuggestedTimes(double[] suggestedTimes) {
        this.suggestedTimes = suggestedTimes;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
