package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoAddingToWaitingLis {




    public DtoAddingToWaitingLis() {
    }



    @JsonProperty
   public String message;

    public DtoAddingToWaitingLis(String message) {
        this.message = message;
    }
}




//    Если свободные дата и время найдены, то response: date и time.
//        Дальше выбор времени, даты, курса (если пользователь вдруг в selector меняет курс, происходит перезагрузка дат),
//        переход к шагу /courseid/choose.
//        Если свободные дата и время не найдены, добавить userid, user’s name, user’s surname и name of the course в список
//        ожидания (/waitinglist) тренера, добавить параметр waiting=true, и выдать сообщение о том, что, к сожалению,
//        на данный курс пока нет свободного времени, но ваше имя добавлено в список ожидающих, и вы будете оповещены,
//        когда появится время для записи.
//
