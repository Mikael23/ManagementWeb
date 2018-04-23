package management.controller;


import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Schedule;
import management.ORM.entity.Trainer;
import management.ORM.entity.AllUsers;
import management.UnauthorizedException;
import management.services.Interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin


public class Controller {


    @Autowired
    TokenInter tokenInter;

    @Autowired
    CourseServiceInt courseServiceInt;
    @Autowired
    TrainerInter trainerInter;
    @Autowired
    UserService userService;

    @Autowired
    TopicInterfaceOut topicInterfaces;

//
//    @GetMapping("trainerid/getCources/{name}")
//    public List<String> listOfCources(@PathVariable("name") String name) {


    @GetMapping("trainerid/gettingUndefiniedTime/")
    public Map<Integer, String> gettingUndefiniedTime(@RequestHeader ("Authorization") String token) throws Exception {

        String email = tokenInter.checkToken(token);
        return trainerInter.gettingUndefiniedTime(email);
    }

    @DeleteMapping("/trainerid/waitinglist/solved/{name}")

    public Integer removingFromWaitingList(@PathVariable("name") String name, @RequestHeader("Authorization") String token) throws UnauthorizedException {

        String email = tokenInter.checkToken(token);

        return trainerInter.removingFromWaitingList(name, email);
    }


    @PostMapping("/trainerid/cancelusertime")
    public String cancelusertime(@RequestBody Schedule schedule, @RequestHeader("Authorization") String token) throws UnauthorizedException {

        String email = tokenInter.checkToken(token);


        return trainerInter.cancelusertime(schedule, email);

    }


    @GetMapping("/trainer/prof/")
    public List<DtoGettingThisDate> trainerConfirmedAndNonConfRequests(@RequestHeader("Authorization") String token) throws UnauthorizedException {

        String email = tokenInter.checkToken(token);


        return trainerInter.trainerConfirmedandNonconfirmed(email);
    }

    @GetMapping("/userid/{date}")
    public List<DtoGettingThisDateN> dtoGettingThisDateN(@RequestHeader ("Authorization")String token, @PathVariable("date") String date) throws UnauthorizedException {

        String email = tokenInter.checkToken(token);

        return userService.dtoGettinThisDateN(email, date);
    }

    @PostMapping("userid/addingToWaitingList")
    public DtoAddingToWaitingLis addTowaintingList(@RequestBody Schedule schedule, @RequestHeader("Authorization") String token) throws Exception {

        String email = tokenInter.checkToken(token);

        return trainerInter.addToWaitingList(schedule,email);
    }

    @GetMapping("/userid/gettingcancelledtimebytrainer")
    public List<DtoCancellation> gettingCancelledRequestsByTrainer(@RequestHeader("Authorization") String token) throws Exception {
        String email = tokenInter.checkToken(token);
        return userService.checkingRejectedRequests(email);
    }


    @DeleteMapping("/userid/rejectrequests/seen/{id}")
    public Integer deleteRequest(@PathVariable("id") Integer id,@RequestHeader("Authorization") String token) throws Exception {
        String email = tokenInter.checkToken(token);
        return userService.deleteRequests(id,email);
    }


    @PostMapping("/trainerid/newrequests/reject")
    public Integer rejectionOfrequest(@RequestBody Schedule schedule,@RequestHeader("Authorization") String token) throws Exception {

        String email = tokenInter.checkToken(token);


        return trainerInter.rejectionRequest(schedule,email);
    }

    @GetMapping("/trainers")
    public List<DtoGettingTrainers> trainers() {
        //returning trainers

        return trainerInter.getTrainers();
    }

    @PostMapping("/proposeCourse")
    public Integer ppoposeOfCourse(@RequestBody Course course,@RequestHeader("Authorization") String token) throws Exception {

        System.out.println(token);

        String email = tokenInter.checkToken(token);



        return courseServiceInt.proposeCourse(course,email);


        ///proposecourse (может предложить любой человек, не проходя регистрацию)

    }

    @PostMapping("/courseid/choose")
    public Integer choosingTime(@RequestBody Schedule schedule,@RequestHeader String token) throws Exception {

        String email = tokenInter.checkToken(token);

        return userService.choosingTime(schedule,email);
    }

    @GetMapping("/courseid/datestimes/{nameCourse}")
    public DtoGettingDatesAndTimes freeDatesandTimes(@PathVariable("nameCourse")  String nameCourse,@RequestHeader String token) throws UnauthorizedException {


         String email = tokenInter.checkToken(token);



//        – получаем незанятые даты и время у конкретного тренера по нажатию «Записаться на курс».
        return trainerInter.gettingDatesAndTimes(nameCourse,email);
    }


//    @PostMapping("/courseid/choose")
//    public String recordForCourse(@RequestBody Course course) {
//
//        //            /courseid/choose – запись на курс на конкретное время
//        return courseServiceInt.choosingAndBookingforCourse(course);
//    }

    @PostMapping("/registration")
    public DtoPostRegistration registration(@RequestBody AllUsers allUsers, @RequestHeader("Authorization") String data) throws Exception {


        String[] Idname = getIdAndPassword(data);
        allUsers.setEmail(Idname[0]);
        allUsers.setPassword(Idname[1]);


        System.out.println("registraciya" + " " + allUsers.password);
        return userService.registration(allUsers);
    }


//    @PostMapping("/login")
//    public DTOlogging loging(@RequestBody AllUsers allUsers) throws Exception {
//        //            /login
//        return userService.logging(allUsers);
//    }

    @PostMapping("/login")
    public ResponseEntity logging(@RequestHeader("Authorization") String data) throws UnauthorizedException {

        AllUsers allUsers = getUser(data);

        System.out.println("controller" + " " + allUsers.password);

        String token = tokenInter.getToken(allUsers);
        HttpHeaders heades = new HttpHeaders();
        heades.add("Authorization", token);
        heades.add("Access-Control-Expose-Headers", "Authorization");
        return new ResponseEntity(heades, HttpStatus.OK);


    }


//    @PostMapping("/login1")
//    public ResponseEntity logging1(@RequestBody AllUsers allUsers) throws UnauthorizedException{
//
//       // AllUsers allUsers = getUser(data);
//
//        System.out.println("controller" + " " + allUsers.password);
//        String token = tokenInter.getToken(allUsers);
//        HttpHeaders heades = new HttpHeaders();
//        heades.add("Authorization", token);
//        return new ResponseEntity(heades, HttpStatus.OK);
//
//    }

    @GetMapping("/cancelledtime/userid/{messageTouser}")
    public DtoCancellation controlCancelledTime(@PathVariable("messageTouser") String messageTouser, @RequestHeader("Authorization")String token) throws UnauthorizedException {
        //    /userid/cancelledtime – слушать отмененные заявки

        String email = tokenInter.checkToken(token);


        return trainerInter.cancellation(messageTouser);
    }


    @GetMapping("/userid/rejectrequests/")
    public DtoGettingCancelledRequest gettingCancelledRequest() {


        return courseServiceInt.gettingCancelledRequest();
    }


    @DeleteMapping("/userid/rejectrequests/seen/")
    public Integer deletionCancelledRequests(@RequestBody Schedule schedule,@RequestHeader("Authorization")String token) throws Exception {

//        удаление отклоненных тренером заявок по кнопочке “просмотрено” (или галочке):
//        Body: {rejectmessage: delete}
//        Response: 200, 401.

        String email = tokenInter.checkToken(token);


        return courseServiceInt.deletionCancelledrecords(schedule,token);
    }


    @GetMapping("/userid/gettingAllRecords{userId}")
    public List<DtoGettingAllUserRecords> getingUserRecords(@PathVariable("userId") Integer userId) {
        // возвращает подтвержденные и неподтвержденные записи юзера на курсы. NE napisan
        return userService.gettingAllUserRecords(userId);
    }


    @PutMapping("/userid/cancelusertime/")
    public DtoPuttingCancellTime puttingCancellTime(@RequestHeader("Authorization") String token, @RequestBody Course course) throws UnauthorizedException {
        //    /userid/cancelusertime - отмена записи. При нажатии вылезает форма «указать причину» (messagetotrainer). ne napisan

        String userId = tokenInter.checkToken(token);
        return userService.puttingCancellTime(course, userId);
    }

    @PutMapping("/userid/update/")
    public DtoUpdatingProfile updatingProfile(@RequestBody AllUsers allUsers, @RequestHeader("Authorization")String token) throws Exception {
        // /userid/update – обновляет информацию профиля пользователя

        String userId = tokenInter.checkToken(token);

        return userService.update(allUsers,userId);
    }

    @GetMapping("/trainerid/waitinglist/")
    public List<DtoGettingWaitingList> getingWaitingList(@RequestHeader("Authorization")String token) throws UnauthorizedException {

        String userId = tokenInter.checkToken(token);
        return trainerInter.gettingWaitingList(userId);
//
///trainerid/waitinglist – лист ожидания, слушать по параметру «waiting»
//    Response: userid, user’s name, user’s surname,
//    ame of the course - пользователи, которые пытались
//    записаться на конкретный курс этого тренера, но не нашли свободное время для сеанса.
//
    }


    @GetMapping("/trainerid/newrequests/")
    public List<DtoGettingNewRequets> newRequets(@RequestHeader("Authorization") String token) throws UnauthorizedException {

        String userId = tokenInter.checkToken(token);

        return trainerInter.getingNewRequest(userId);
//    GET:
//            /trainerid/newrequests – новые заявки (фильтруются по параметру busy=true, confirmed = false).
//    Response: {courseid, name of the course, userid, user’s name, user’s surname, date, time }.
    }


    @PostMapping("/trainerid/newrequests/confirmation")
    public Integer confirmation(@RequestBody Schedule schedule,@RequestHeader("Authorization") String token) throws Exception {
        String userId = tokenInter.checkToken(token);


        return trainerInter.confirmationRequest(schedule,userId);




///trainerid/newrequests/confirmation – подтверждение новой заявки по нажатию «подтвердить»
//        Body: я отправляю {courseid, userid, date, time, confirmed = true}, нужная заявка находится по courseid, userid, date, time.
//                Response: 200 or 401, confirmed меняется на true, отправка e-mail userid о
//        подтверждении с данными: name of the course, trainer’s name, trainer’s surname, date, time.

    }

    @GetMapping("admin/proposedcourses")
    public List<DtoGettingProposedCourse> newProposedCourse(@RequestHeader("Authorization") String token) throws Exception {

        String userId = tokenInter.checkToken(token);

        return courseServiceInt.getingProposedCourse(userId);
        //admin/proposedcourses – получение новых заявок на новые курсы, фильтруется по параметру
    }


    @DeleteMapping("/admin/proposedcourses/reject/{coursename}")
    public Integer proposedCourseRejection(@PathVariable("coursename") String courseName, @RequestHeader("Authorization") String token) throws Exception {

        //            /admin/proposedcourses/reject – удаление предложения курса по нажатию «отклонить»

        String userId = tokenInter.checkToken(token);
        return courseServiceInt.deletionProposedCourse(courseName,userId);
    }

    @GetMapping("/trainerid/{trainerId}")
    public DtoGettingConfirmedRequests gettingConfirmedRequests(@PathVariable("trainerId") Integer trainerId) {




//        /trainerid/”текущая дата, от которой будет выстраиваться неделя” – возвращает подтвержденные заявки,
//                фильтрация по confirmed=true, и свободные интервалы (фильтрация по busy = false)
//        Response: подтвержденные заявки: name of the course, date (относительно текущего дня + неделя),
//        t ime, userid, user’s name, user’s surname. свободные интервалы: name of the course
//        (массив курсов, которые гипотетически будут проводиться в этот интервал времени), date, time.

        // ne sdelan

        return courseServiceInt.gettingConfirmedRequests(trainerId);
///trainerid/”текущая дата, от которой будет выстраиваться неделя” –

    }

    @GetMapping("/trainerid/courses/{email}")
    public List<DtoGettingCourcesOnTrainerId> gettingCourcesOnTrainerId(@RequestHeader("Authorization")String token) throws UnauthorizedException {
        //  подгрузка курсов, которые ведет тренер
        String userId = tokenInter.checkToken(token);
        return trainerInter.getingCourseOnTrainerId(userId);
    }


    @GetMapping("trainerid/schedule/")
    public List<DtoGettingCourcesOnTrainerId> gettingTrainersNameAndTheirNumberInScheduleTable(@RequestHeader("Authorization") String token) throws Exception {

        String email = tokenInter.checkToken(token);

        return trainerInter.gettingTrainersNameAndTheirNumberInScheduleTable(email);
    }


    @CrossOrigin
    @PostMapping("trainerid/addinterval/")
    public Integer addingInterval(@RequestBody Schedule schedule,@RequestHeader("Authorization")String token) throws Exception {
        ///trainerid/addinterval – непосредственно добавление интервала.
        String email = tokenInter.checkToken(token);
        return trainerInter.addingInterval(schedule,email);
    }


    @DeleteMapping("/trainerid/removeinterval/")
    public Integer deletionO(@RequestBody Schedule schedule,@RequestHeader("Authorization")String token) throws Exception {

        String email = tokenInter.checkToken(token);

        return trainerInter.deletionOfInterval(schedule,email);


        // /  /trainerid/removeinterval - удалить ранее заданное как свободное время, кнопочка на календаре
    }

    @CrossOrigin

    @PostMapping("/admin/addcourse")
    public DtoPostAddingCourse postAddingCourse(@RequestBody Course course, @RequestHeader("Authorization")String token) throws Exception {
        //    /admin/addcourse - добавить course и привязать его к тренеру:

        String email = tokenInter.checkToken(token);

        return courseServiceInt.addingCourse(course,email);
    }


    @DeleteMapping("/admin/removecourse/{name}")
    public Integer removeOfCourse(@PathVariable("name") String name,@RequestHeader("Authorization")String token) throws Exception {

        //    DELETE:
//            /admin/removecourse
        String email = tokenInter.checkToken(token);

        return courseServiceInt.removeCourse(name,email);


    }

    @PostMapping("/admin/addtrainer")
    public Integer addingTrainer(@RequestBody Trainer trainer,@RequestHeader("Authorization")String token) throws Exception {


        String email = tokenInter.checkToken(token);

        return trainerInter.addingTrainer(trainer,email);
    }


    @PostMapping("/admin/maketrainer/")
    public Integer makertrainer(@RequestBody AllUsers allUsers, @RequestHeader("Authorization")String token) throws Exception {

        String emaill = tokenInter.checkToken(token);

        System.out.println(emaill);



        return trainerInter.makerTrainer(allUsers.email,emaill);
    }


    @GetMapping("/admin/trainersid")
    public List<String> namesOfTrainer() {

        return trainerInter.returningTrainerNames();
    }


    @GetMapping("/admin/courses")
    public List<DtoGettingCourses> gettingCources() {

        return courseServiceInt.gettingCources();
    }


    @GetMapping("admin/allUsersId")
    public List<String> usersId() {
        return userService.allUserId();
    }


    @PostMapping("/admin/editcourse/")
    public Integer courseEdition(@RequestBody Course course) throws Exception {
        return courseServiceInt.etitionOfCourse(course);
    }

    @PostMapping("/userid/cancelusertime/")
    public Integer cancelByUser(@RequestBody Schedule schedule) throws Exception {
        return userService.cancellTimeByUser(schedule);
    }

    @PostMapping("/userid/cancelnonconfirmedusertime")
    public Integer cancellOfNotConfirmedTime(@RequestBody Schedule schedule) throws Exception {


        return userService.cancellOfNotConfirmedTime(schedule);
    }

    @GetMapping("/trainerid/cancelledtime")
    public List<DtoTrainerCancellationRecords> cancelledRecords() {
        return trainerInter.checkingCancelledRecords();
    }

    /////////////////////////////////////////////////////////


    @RequestMapping("/top")
    public int getInt() {
        System.out.println("management/controller");
        return 1;
    }

    @GetMapping("/topics")
    public List<TopicDTO> getTopics() {
        System.out.println(topicInterfaces.getAllTopics());
        return topicInterfaces.getAllTopics();
    }

    @GetMapping("/topicsSwf")
    public List<TopicSwfDTO> getTopicsSwf() {
        System.out.println(topicInterfaces.getAllTopics());
        return topicInterfaces.getAllTopicsSwf();
    }

    @PostMapping("/addtopic")
    public int newTopic(@RequestBody TopicDTO topic) { //response create or no

        System.out.println(topic);
        int responce = topicInterfaces.addNewTopic(topic);

        return responce;
    }



    @GetMapping("/getcourseByName")
    public Course getCourseByName(@RequestBody Course course){
        Course course1 = courseServiceInt.getCourseByName(course.nameOfCourse);
        System.out.println(course);
        return course;
    }

    ////////
    private AllUsers getUser(String data) {
        AllUsers allUsers = new AllUsers();
        data = data.split(" ")[1];
        byte[] decoded = Base64.getDecoder().decode(data);
        String namePass = new String(decoded);
        String[] res = namePass.split(":");
        allUsers.setPassword(res[1]);
        allUsers.setEmail(res[0]);
        return allUsers;
    }

    private String[] getIdAndPassword(String data) {


        data = data.split(" ")[1];
        byte[] decoded = Base64.getDecoder().decode(data);
        String namePass = new String(decoded);
        String[] res = namePass.split(":");

        return res;

    }

}
