package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingTrainers {

    @JsonProperty
      public String name;
    @JsonProperty
  public  String description;
    @JsonProperty
  public  String URLPhoto;

    public String[] getNameOfCources() {
        return nameOfCources;
    }

    public void setNameOfCources(String[] nameOfCources) {
        this.nameOfCources = nameOfCources;
    }

    @JsonProperty
    public String[]nameOfCources;

    public String getNameOfTopic() {
        return nameOfTopic;
    }

    public void setNameOfTopic(String nameOfTopic) {
        this.nameOfTopic = nameOfTopic;
    }

    @JsonProperty
    public String nameOfTopic;



    public DtoGettingTrainers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURLPhoto() {
        return URLPhoto;
    }

    public void setURLPhoto(String URLPhoto) {
        this.URLPhoto = URLPhoto;
    }

}








