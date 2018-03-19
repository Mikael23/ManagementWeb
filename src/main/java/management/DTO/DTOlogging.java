package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DTOlogging {




  @JsonProperty
    public String name;

  @JsonProperty

    public String surname;

  @JsonProperty

    public String role;









//    /login
//    Body: {email, password}
//    Response: userid, name, surname, role: trainer or user, в зависимости
//    от роли выстраивается кабинет пользователя как тренера или юзера.
//    После логина - направлению на страницу, с которой был запуск логина.

}
