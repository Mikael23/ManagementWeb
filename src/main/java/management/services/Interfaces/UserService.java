package management.services.Interfaces;

import management.DTO.*;
import management.ORM.entity.AllUsers;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    List<DtoGettingAllUserRecords> gettingAllUserRecords(Integer userId);



    boolean login(AllUsers allUsers);





    List<String>allUserId();


//    GET:
//            /admin/usersid - нужно иметь возможность подгрузить все userid
//    Response: {массив из всех userid}.






    DtoGettingThisDateN gettingDateOfUser(Integer id);


//    GET:
//
//            /userid/”текущая дата, от которой будет выстраиваться месяц” –
//    возвращает подтвержденные и неподтвержденные записи юзера на курсы.
//    Response: name of the course, date (относительно текущего месяца), t
//    ime, trainerid, trainer’s name, trainer’s surname, confirmed(true or false)
//    Ниже кнопка «отменить запись».
//


    DTOlogging logging(AllUsers allUsers) throws Exception;




///login
//    Body: {email, password}
//    Response: userid, name, surname, role: trainer or user, в зависимости от роли выстраивается
//    кабинет пользователя как тренера или юзера. После логина - направлению на страницу, с которой был запуск логина.


    DtoUpdatingProfile update(AllUsers user) throws Exception;

//    PUT: - кнопка «редактировать личные данные»
//            /userid/update – обновляет информацию профиля пользователя
//    Body: {name, surname, old password, new password, repeat new password, phone, city,
//            skype, viber, whatsapp, telegram, vk, facebook, instagram }
//    Response: name, surname, 200 or 401


    String choosingTime(Course course, String email) throws Exception;

    DTOlogging dtoLogging(AllUsers allUsers);


    DtoPuttingCancellTime puttingCancellTime(Course course, Integer userId);


//    /userid/cancelusertime - отмена записи. При нажатии вылезает форма «указать причину» (messagetotrainer).
//    Body: {courseid, date, time, messagetotrainer, busy=false, confirmed = false}
//    Response: проверка по данным на наличие записи на это время на этот курс этого юзера.
//    Если все ок, отправка сообщения на e-mail trainerid об отмене, который ведет courseid,
//    c данными: userid, user’s name, user’s surname, name of the course, date, time, messagetotrainer.
//    date и time снова становятся свободными: поле busy меняется на false, поле confirmed меняется на false.


    DtoGettingThisDateN dtoGettinThisDateN(AllUsers allUsers);


//    /userid/”текущая дата, от которой будет выстраиваться месяц” –
//    возвращает подтвержденные и неподтвержденные записи юзера на курсы.
//    Response: name of the course, date (относительно текущего месяца),
//    time, trainerid, trainer’s name, trainer’s surname, confirmed(true or false)
//    Ниже кнопка «отменить запись».


    //   DeletionCanceledTime deletionCancelledTime(Course course);

//        /userid/cancelledtime/seen – удаление отмененных заявок по кнопочке “просмотрено”:
//    Body: {messagetouser: delete}
//    Response: 200, 401.


///login
//        Body: {email, password}
//        Response: userid, name, surname, role: trainer or user,
//        в зависимости от роли выстраивается кабинет пользователя как тренера или юзера.
//        После логина - направлению на страницу, с которой был запуск логина.


    DtoPostRegistration registration(AllUsers allUsers) throws Exception;
//POST:
//        /registration
//        Body:  {name, surname, email, password, repeatpassword, phone, dateofbirth,
//        city – заполнение всех полей обязательно; skype, viber, whatsapp, telegram, vk, facebook, instagram – не обязательно}, role=user}
//        Response: назначить id юзеру – userid, направление на страницу, с которой был
//        запуск регистрации, назначить role – по умолчанию всегда user (на trainer может изменить администратор).
}


///trainerid/update – обновляет информацию профиля пользователя
//        Body: {name, surname, old password, new password, repeat new password, phone,
//        city, skype, viber, whatsapp, telegram, vk, facebook, instagram }




