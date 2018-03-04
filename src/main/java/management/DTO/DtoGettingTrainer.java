package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoGettingTrainer {



    @JsonProperty("description")
    public String description;
    @JsonProperty("photo")
    public String URLPhoto;

    public DtoGettingTrainer() {
    }

    @JsonProperty("name")
    public String name;

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



//POST:
//        /courseid/choose – запись на курс на конкретное время
//        Body: { courseid, userid, date, time, confirmed = false }
//        Response: вернуть ошибку, если пользователь уже записан на это время
//        Если все успешно, данные дата и время попадают в неподтвержденные записи у тренера,
//        и как неподтвержденные – в личный кабинет пользователя, тренеру отправляется оповещение на
//        e-mail о новой записи. Выбранное время перестает быть свободным.
//        В базу данных заносится параметр confirmed = false, который поменяется на true после подтверждения.
//        Значение busy меняется на true.
//        Пока есть косяк с тем, как уменьшать после записи юзера количество (quantity) оставшихся мест для записи на конкретный интервал времени.
