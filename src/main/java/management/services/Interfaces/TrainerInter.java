package management.services.Interfaces;

import management.DTO.*;
import management.ORM.entity.AllUsers;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainerInter {


    List<DtoGettingCourcesOnTrainerId> getingCourseOnTrainerId(Integer id);


    Integer deletionFreeTimeInterval(Course course, Integer trainerId);
//    DELETE:
//            /trainerid/removeinterval - удалить ранее заданное как свободное время, кнопочка на календаре


    Integer addingInterval(Integer id, Course course);
    //    /trainerid/addinterval – непосредственно добавление интервала.



    DtoGettingTrainers gettingTrainers(String email);
//    GET:
//            /trainerid/courses – при добавлении свободного времени (интервала) подгрузка курсов, которые ведет тренер
//    Response: courseid, name of the course (которые ведет тренер).
//


    Integer rejectionRequest(Integer id, Course course);
//
///trainerid/newrequests/reject – отклонение новой заявки по нажатию «отклонить».
//    При нажатии вылезает форма «указать причину» (rejectmessage).
//

    Integer confirmationRequest(Course course);


//    /trainerid/newrequests/confirmation – подтверждение новой заявки по нажатию «подтвердить»
//    Body: я отправляю {courseid, userid, date, time, confirmed = true},
//    нужная заявка находится по courseid, userid, date, time.
    //  Response: 200 or 401, confirmed меняется на true.


    DtoGettingNewRequets getingNewRequest(Integer id);

//    GET:
//            /trainerid/newrequests – новые заявки (фильтруются по параметру busy=true, confirmed = false).
//    Response: {courseid, name of the course, userid, user’s name, user’s surname, date, time }.
//
//


    Integer addingTrainer(Trainer trainer) throws Exception;

    Trainer gettingTrainer(String name);


    List<DtoGettingWaitingList> gettingWaitingList(Integer id);
//    /trainerid/waitinglist – лист ожидания, слушать по параметру «waiting»


    DtoAddingToWaitingLis addToWaitingList(AllUsers allUsers);


//    Если свободные дата и время найдены, то response: date и time.
//    Дальше выбор времени, даты, курса (если пользователь вдруг в selector меняет курс,
//                                       происходит перезагрузка дат), переход к шагу /courseid/choose.
//    Если свободные дата и время не найдены, добавить userid, user’s name, user’s surname
//    и name of the course в список ожидания (/waitinglist) тренера, добавить параметр waiting=true, \
//    и выдать сообщение о том, что, к сожалению, на данный курс пока нет свободного времени,
//    но ваше имя добавлено в список ожидающих, и вы будете оповещены, когда появится время для записи.


    DtoGettingDatesAndTimes gettingDatesAndTimes(Integer id);
    ///courseid/datestimes – получаем незанятые даты и время у конкретного тренера по нажатию «Записаться на курс».
//        По courseid смотрим, какие даты с каким временем свободные. Диапазон дат для записей – месяц.
//        Если пользователь не залогинен, - переадресация на логин/регистрацию и после нее получение возможных дат и времени.
//        Когда пользователь залогинен, будет ли добавляться ко всем ссылкам-действиям вначале /userid, где оно важно?
//        Важно привязать конкретные курсы к конкретным тренерам. Чтобы курсы с id (к примеру) 1,2,3 попадали в расписание тренера trainerid.
//        Response:
//        Если свободные дата и время найдены, то response: date и time. Дальше выбор времени, даты, курса (если пользователь вдруг
//        в selector меняет курс, происходит перезагрузка дат), переход к шагу /courseid/choose.
//        Если свободные дата и время не найдены, добавить userid, user’s name, user’s surname и name of the course в список
//        ожидания (/waitinglist) тренера, добавить параметр waiting=true, и выдать сообщение о том, что, к сожалению,
//        на данный курс пока нет свободного времени, но ваше имя добавлено в список ожидающих, и вы будете оповещены,
//        когда появится время для записи.


    List<DtoGettingTrainers> getTrainers();
///trainers – получить список действующих тренеров
// Response: trainers: {name, description, photo, {массив name of the courses,
//         которые ведет тренер + topic, к которому относится курс}}
// POST:


    List<String>returningTrainerNames();


    DtoCancellation cancellation(String messageToUser);

// GET:
//         /userid/cancelledtime – Отслеживание отмененные заявки
// Response: как только появляется поле “messagetouser”, приходят поля: trainerid,
// trainer’s name, trainer’s surname, name of the course, date, time, messagetouser.


    List<String> listOfcources(Trainer trainer);

    double[] deletionOfInterval(String name);

    double[] addingSuggestedCourseInterval(Course course);

    Integer makerTrainer(String userName) throws Exception;


    //    POST:
//            /admin/addtrainer - добавить тренера на страницу тренеров:
//    Body: {name, description, photo}
//    Response: 200 or 401

}
