package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import java.time.LocalDateTime;

public class DtoGettingNewRequets {

    @JsonProperty
    public Integer userid;
    @JsonProperty
    public String userName;
    @JsonProperty
    public String userSurname;

    @JsonProperty
    Integer time;

    @JsonProperty
    public Integer courseId;
    @JsonProperty
    public String NameOfCourse;



    public String localDateTime;


    public DtoGettingNewRequets() {
    }



}


