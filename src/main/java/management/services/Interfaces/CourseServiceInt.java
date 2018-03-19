package management.services.Interfaces;

import management.DTO.*;
import management.ORM.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CourseServiceInt {


    DtoGettingCancelledRequest gettingCancelledRequest();


    Integer deletionCancelledrecords(Integer courseId);

//    /userid/cancelledtime/seen – удаление отмененных заявок по кнопочке “просмотрено”:
//    Body: {messagetouser: delete}
//    Response: 200, 401.


    Integer removeCourse(Integer courseId) throws Exception;



//    admin/removecourse
//    Body: {courseid: remove}
//    Response: удалить все данные: courseid, name of the course, description,
//            trainerid, duration, quantity, confirmed = true. 200 or 401.
//


    DtoPostAddingCourse addingCourse(Course course) throws Exception;

//
//    POST:
//            /admin/addcourse - добавить course и привязать его к тренеру:
//    Body: {courseid, name of the course, description, trainerid, duration, quantity
//            (максимальное количество записей на сессию), confirmed = true}
//    Response: courseid связать с trainerid , поля yourname и phone удалить, поле confirmed поменять на true.
//    Ошибка может быть в случае, если такой courseid уже существует.


    DtoGettingConfirmedRequests gettingConfirmedRequests(Integer trainerId);


///trainerid/”текущая дата, от которой будет выстраиваться неделя” –
//    возвращает подтвержденные заявки, фильтрация по confirmed=true, и свободные интервалы (фильтрация по busy = false)
//    Response: подтвержденные заявки: name of the course, date (относительно текущего дня + неделя),
//    time, userid, user’s name, user’s surname. свободные интервалы: name of the course
//            (массив курсов, которые гипотетически будут проводиться в этот интервал времени), date, time.
//


    Integer deletionProposedCourse(String courseId) throws Exception;
//
///admin/proposedcourses/reject – удаление предложения курса по нажатию «отклонить»
//    Body: {courseid (если уже сформирован): delete}
//    Response: удаляются все поля: courseid, name of the course,
//    description, duration, (длительность сессии), quantity (максимальное количество записей на сессию),
//    yourname, phone, confirmed = false, 200 or 401


    List<DtoGettingProposedCourse> getingProposedCourse();


///admin/proposedcourses – получение новых заявок на новые курсы, фильтруется по параметру confirmed = false
//    Response: {courseid (если уже сформирован), name of the course, description, duration, (длительность сессии),
//        quantity (максимальное количество записей на сессию), yourname, phone }


    int proposeCourse(Course course) throws Exception;



    Integer etitionOfCourse(Course course) throws Exception;






    List<DtoGettingCourses> gettingCources();




    Map<String, Course> gettingProposedCources();

    String deletedSuggestedCources(int id, String name);

    int addCourse(Course course);


    CourseDateAndTimesResponse gettingFreeTimesandDuration(Integer id) throws Exception;

    String choosingAndBookingforCourse(Course course);


//  POST:
//            /courseid/choose – запись на курс на конкретное время
//    Body: { courseid, userid, date, time, confirmed = false }
//    Response: вернуть ошибку, если пользователь уже записан на это время
//    Если все успешно, данные дата и время попадают в неподтвержденные записи у тренера,
//    и как неподтвержденные – в личный кабинет пользователя, тренеру отправляется оповещение
//    на e-mail о новой записи. Выбранное время перестает быть свободным. В базу данных заносится параметр confirmed = false,
//    который поменяется на true после подтверждения. Значение busy меняется на true.
//    Пока есть косяк с тем, как уменьшать после записи юзера количество (quantity) оставшихся мест для записи на конкретный интервал времени.
//
//
//}

}

