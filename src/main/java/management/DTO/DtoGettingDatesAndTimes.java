package management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class DtoGettingDatesAndTimes {
    public DtoGettingDatesAndTimes() {
    }

    public List<String> datesandTimes = new LinkedList<>();
    public List<String> trainerName = new LinkedList<>();
    public List<Integer> setsId = new LinkedList<>();


}


///courseid/datestimes – получаем незанятые даты и время у конкретного тренера по нажатию «Записаться на курс».
//        По courseid смотрим, какие даты с каким временем свободные. Диапазон дат для записей – месяц.
//        Если пользователь не залогинен, - переадресация на логин/регистрацию и после нее получение возможных дат и времени.
//        Когда пользователь залогинен, будет ли добавляться ко всем ссылкам-действиям вначале /userid, где оно важно?
//        Важно привязать конкретные курсы к конкретным тренерам. Чтобы курсы с id (к примеру) 1,2,3 попадали в расписание тренера trainerid.
//        Response:
//        Если свободные дата и время найдены, то response: date и time.
//        Дальше выбор времени, даты, курса (если пользователь вдруг в selector меняет курс, происходит перезагрузка дат),
//        переход к шагу /courseid/choose.
//        Если свободные дата и время не найдены, добавить userid, user’s name, user’s surname и name of the course
//        в список ожидания (/waitinglist) тренера, добавить параметр waiting=true, и выдать сообщение о том, что,
//        к сожалению, на данный курс пока нет свободного времени, но ваше имя добавлено в список ожидающих,
//        и вы будете оповещены, когда появится время для записи.
