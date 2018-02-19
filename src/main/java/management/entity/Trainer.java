package management.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trainer {

    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public String description;

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", surname='" + surname + '\'' +
                '}';
    }

    //   @JsonProperty("id")
    public Integer id;
    @JsonProperty("surname")
    public String surname;



    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Trainer() {
    }
}


//    POST:
//            /admin/addtrainer - добавить тренера на страницу тренеров:
//    Body: {name, description, photo}
//    Response: 200 or 401
