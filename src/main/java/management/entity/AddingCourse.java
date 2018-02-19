package management.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddingCourse {

  @JsonProperty("name")  public String name;
    @JsonProperty ("description") public String description;

    @JsonProperty("trainerName")  public String trainerName;
    @JsonProperty("duration") public Integer duration;
    @JsonProperty("quantatity") public Integer quantatity;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Trainer trainer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("id") public Integer id;

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

    public String getTrainerid() {
        return trainerName;
    }

    public void setTrainerid(String trainerName) {
        this.trainerName = trainerName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getQuantatity() {
        return quantatity;
    }

    public void setQuantatity(Integer quantatity) {
        this.quantatity = quantatity;
    }


    public AddingCourse() {
    }
}



