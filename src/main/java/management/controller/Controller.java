package management.controller;


import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.AllUsers;
import management.services.Interfaces.CourseServiceInt;
import management.services.Interfaces.TrainerInter;
import management.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class Controller {


    @Autowired
    CourseServiceInt courseServiceInt;
    @Autowired
    TrainerInter trainerInter;
    @Autowired
    UserService userService;

//
//    @GetMapping("trainerid/getCources/{name}")
//    public List<String> listOfCources(@PathVariable("name") String name) {


    @GetMapping("/trainers")
    public List<DtoGettingTrainers> trainers() {
        //returning trainers
        return trainerInter.getTrainers();
    }

    @PostMapping("/proposeCourse")
    public Integer ppoposeOfCourse(@RequestBody Course course) throws Exception {


        return courseServiceInt.proposeCourse(course);


        ///proposecourse (может предложить любой человек, не проходя регистрацию)

    }

    @GetMapping("/courseid/datestimes/{trainerId}")
    public DtoGettingDatesAndTimes freeDatesandTimes(@PathVariable("trainerId") Integer trainerId) {


//        – получаем незанятые даты и время у конкретного тренера по нажатию «Записаться на курс».
        return trainerInter.gettingDatesAndTimes(trainerId);
    }


    @PostMapping("/courseid/choose")
    public String recordForCourse(@RequestBody Course course) {

        //            /courseid/choose – запись на курс на конкретное время
        return courseServiceInt.choosingAndBookingforCourse(course);
    }

    @PostMapping("/registration")
    public DtoPostRegistration registration(@RequestBody AllUsers allUsers) throws Exception {

//            /registration
        return userService.registration(allUsers);
    }


    @PostMapping("/login")
    public DTOlogging loging(@RequestBody AllUsers allUsers) throws Exception {
        //            /login
        return userService.logging(allUsers);
    }

    @GetMapping("/cancelledtime/userid/{messageTouser}")
    public DtoCancellation controlCancelledTime(@PathVariable("messageTouser") String messageTouser) {
        //    /userid/cancelledtime – слушать отмененные заявки
        return trainerInter.cancellation(messageTouser);
    }


    @GetMapping("/userid/rejectrequests/")
    public DtoGettingCancelledRequest gettingCancelledRequest() {
///userid/cancelledtime/seen – удаление отмененных заявок по кнопочке “просмотрено”:
        return courseServiceInt.gettingCancelledRequest();
    }


    @DeleteMapping("/userid/rejectrequests/seen/{courseId}")
    public Integer deletionCancelledRequests(@PathVariable("courseId") Integer courseId) {
        return courseServiceInt.deletionCancelledrecords(courseId);
    }


    @GetMapping("/userid/gettingAllRecords{userId}")
    public List<DtoGettingAllUserRecords> getingUserRecords(@PathVariable("userId") Integer userId) {
        // возвращает подтвержденные и неподтвержденные записи юзера на курсы.
        return userService.gettingAllUserRecords(userId);
    }


    @PutMapping("/userid/cancelusertime/{userId}")
    public DtoPuttingCancellTime puttingCancellTime(@PathVariable("userId") Integer userId, @RequestBody Course course) {
        //    /userid/cancelusertime - отмена записи. При нажатии вылезает форма «указать причину» (messagetotrainer).

        return userService.puttingCancellTime(course, userId);
    }

    @PutMapping("/userid/update/")
    public DtoUpdatingProfile updatingProfile(@RequestBody AllUsers allUsers) throws Exception {
        // /userid/update – обновляет информацию профиля пользователя
        return userService.update(allUsers);
    }

    @GetMapping("/trainerid/waitinglist/{userId}")
    public List<DtoGettingWaitingList> getingWaitingList(@PathVariable("userId") Integer userId) {
        return trainerInter.gettingWaitingList(userId);
//
///trainerid/waitinglist – лист ожидания, слушать по параметру «waiting»
//    Response: userid, user’s name, user’s surname,
//    ame of the course - пользователи, которые пытались
//    записаться на конкретный курс этого тренера, но не нашли свободное время для сеанса.
//
    }


    @GetMapping("/trainerid/newrequests/{trainerId}")
    public DtoGettingNewRequets newRequets(@PathVariable("trainerId") Integer trainerId) {
        return trainerInter.getingNewRequest(trainerId);
//    GET:
//            /trainerid/newrequests – новые заявки (фильтруются по параметру busy=true, confirmed = false).
//    Response: {courseid, name of the course, userid, user’s name, user’s surname, date, time }.
    }


    @PutMapping("/trainerid/newrequests/confirmation")
    public Integer confirmation(@RequestBody Course course) {
        return trainerInter.confirmationRequest(course);

        //            /trainerid/newrequests/confirmation – подтверждение новой заявки

    }

    @GetMapping("admin/proposedcourses")
    public List<DtoGettingProposedCourse> newProposedCourse() {


        return courseServiceInt.getingProposedCourse();
        //admin/proposedcourses – получение новых заявок на новые курсы, фильтруется по параметру
    }


    @DeleteMapping("/admin/proposedcourses/reject/{courseName}")
    public Integer proposedCourseRejection(@PathVariable("courseName") String courseName) throws Exception {

        //            /admin/proposedcourses/reject – удаление предложения курса по нажатию «отклонить»

        return courseServiceInt.deletionProposedCourse(courseName);
    }

    @GetMapping("/trainerid/{trainerId}")
    public DtoGettingConfirmedRequests gettingConfirmedRequests(@PathVariable("trainerId") Integer trainerId) {


        return courseServiceInt.gettingConfirmedRequests(trainerId);
///trainerid/”текущая дата, от которой будет выстраиваться неделя” –

    }

    @GetMapping("/trainerid/courses/{trainerId}")
    public List<DtoGettingCourcesOnTrainerId> gettingCourcesOnTrainerId(@PathVariable("trainerId") Integer trainerId) {
        //  подгрузка курсов, которые ведет тренер
        return trainerInter.getingCourseOnTrainerId(trainerId);
    }


    @PostMapping("trainerid/addinterval/{trainerId}")
    public Integer addingInterval(@PathVariable("trainerId") Integer trainerId, @RequestBody Course course) {
        ///trainerid/addinterval – непосредственно добавление интервала.
        return trainerInter.addingInterval(trainerId, course);
    }


    @DeleteMapping("/trainerid/removeinterval/{trainerId}")
    public Integer deletionOffreeIntervals(@PathVariable("trainerId") Integer trainerId, @RequestBody Course course) {
        return trainerInter.deletionFreeTimeInterval(course, trainerId);
        //  /trainerid/removeinterval - удалить ранее заданное как свободное время, кнопочка на календаре
    }


    @PostMapping("/admin/addcourse")
    public DtoPostAddingCourse postAddingCourse(@RequestBody Course course) throws Exception {
        //    /admin/addcourse - добавить course и привязать его к тренеру:
        return courseServiceInt.addingCourse(course);
    }


    @DeleteMapping("/admin/removecourse/{courseId}")
    public Integer removeOfCourse(@PathVariable("courseId") Integer courseId) throws Exception {

        //    DELETE:
//            /admin/removecourse
        return courseServiceInt.removeCourse(courseId);


    }

    @PostMapping("/admin/addtrainer")
    public Integer addingTrainer(@RequestBody Trainer trainer) throws Exception {


        return trainerInter.addingTrainer(trainer);
    }


    @PostMapping("/admin/maketrainer/")
    public Integer makertrainer(@RequestBody AllUsers allUsers) throws Exception {

        return trainerInter.makerTrainer(allUsers.email);
    }


    @GetMapping("/admin/trainersid")
    public List<String> namesOfTrainer() {

        return trainerInter.returningTrainerNames();
    }


    @GetMapping("/admin/courses")
    public List<DtoGettingCourses> gettingCources() {

        return courseServiceInt.gettingCources();
    }


    @GetMapping("admin/usersid")
    public List<String> usersId() {
        return userService.allUserId();
    }


    @PostMapping("/admin/editcourse/")
    public Integer courseEdition(@RequestBody Course course) throws Exception {
        return courseServiceInt.etitionOfCourse(course);
    }




}
