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


    @GetMapping("trainerid/gettingUndefiniedTime/{email}")
    public Map<Integer, String> gettingUndefiniedTime(@PathVariable("email") String email) throws Exception {

        return trainerInter.gettingUndefiniedTime(email);
    }

    @DeleteMapping("/trainerid/waitinglist/solved/{name}")

    public Integer removingFromWaitingList(@PathVariable("name") String name) {
        return trainerInter.removingFromWaitingList(name);
    }


    @PostMapping("/trainerid/cancelusertime")
    public String cancelusertime(@RequestBody Schedule schedule) {

        return trainerInter.cancelusertime(schedule);

    }


    @GetMapping("/trainer/prof/{name}")
    public List<DtoGettingThisDate> trainerConfirmedAndNonConfRequests(@PathVariable("name") String name) {

        return trainerInter.trainerConfirmedandNonconfirmed(name);
    }

    @GetMapping("/userid/{date}")
    public List<DtoGettingThisDateN> dtoGettingThisDateN(@RequestBody AllUsers user, @PathVariable("date") String date) {

        return userService.dtoGettinThisDateN(user, date);
    }

    @PostMapping("userid/addingToWaitingList")
    public DtoAddingToWaitingLis addTowaintingList(@RequestBody Schedule schedule) throws Exception {
        return trainerInter.addToWaitingList(schedule);
    }

    @GetMapping("/userid/gettingcancelledtimebytrainer")
    public List<DtoCancellation> gettingCancelledRequestsByTrainer() {

        return userService.checkingRejectedRequests();
    }


    @DeleteMapping("/userid/rejectrequests/seen/{id}")
    public Integer deleteRequest(@PathVariable("id") Integer id) throws Exception {
        return userService.deleteRequests(id);
    }


    @PostMapping("/trainerid/newrequests/reject")
    public Integer rejectionOfrequest(@RequestBody Schedule schedule) throws Exception {

        return trainerInter.rejectionRequest(schedule);
    }

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

    @PostMapping("/courseid/choose")
    public Integer choosingTime(@RequestBody Schedule schedule) throws Exception {
        return userService.choosingTime(schedule);
    }

    @GetMapping("/courseid/datestimes/{nameCourse}")
    public DtoGettingDatesAndTimes freeDatesandTimes(@PathVariable("nameCourse") String nameCourse) {


//        – получаем незанятые даты и время у конкретного тренера по нажатию «Записаться на курс».
        return trainerInter.gettingDatesAndTimes(nameCourse);
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


    @PostMapping("/login1")
    public ResponseEntity logging1(@RequestBody AllUsers allUsers) throws UnauthorizedException {

        // AllUsers allUsers = getUser(data);

        System.out.println("controller" + " " + allUsers.password);
        String token = tokenInter.getToken(allUsers);
        HttpHeaders heades = new HttpHeaders();
        heades.add("Authorization", token);
        return new ResponseEntity(heades, HttpStatus.OK);

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


    @DeleteMapping("/userid/rejectrequests/seen/")
    public Integer deletionCancelledRequests(@RequestBody Schedule schedule) throws Exception {
        return courseServiceInt.deletionCancelledrecords(schedule);
    }


    @GetMapping("/userid/gettingAllRecords{userId}")
    public List<DtoGettingAllUserRecords> getingUserRecords(@PathVariable("userId") Integer userId) {
        // возвращает подтвержденные и неподтвержденные записи юзера на курсы.
        return userService.gettingAllUserRecords(userId);
    }


    @PutMapping("/userid/cancelusertime/")
    public DtoPuttingCancellTime puttingCancellTime(@RequestHeader("Authorization") String token, @RequestBody Course course) throws UnauthorizedException {
        //    /userid/cancelusertime - отмена записи. При нажатии вылезает форма «указать причину» (messagetotrainer).

        String userId = tokenInter.checkToken(token);
        return userService.puttingCancellTime(course, userId);
    }

    @PutMapping("/userid/update/")
    public DtoUpdatingProfile updatingProfile(@RequestBody AllUsers allUsers) throws Exception {
        // /userid/update – обновляет информацию профиля пользователя
        return userService.update(allUsers);
    }

    @GetMapping("/trainerid/waitinglist/{email}")
    public List<DtoGettingWaitingList> getingWaitingList(@PathVariable("email") String email) {
        return trainerInter.gettingWaitingList(email);
//
///trainerid/waitinglist – лист ожидания, слушать по параметру «waiting»
//    Response: userid, user’s name, user’s surname,
//    ame of the course - пользователи, которые пытались
//    записаться на конкретный курс этого тренера, но не нашли свободное время для сеанса.
//
    }


    @GetMapping("/trainerid/newrequests/{trainerName}")
    public List<DtoGettingNewRequets> newRequets(@PathVariable("trainerName") String trainerName) {
        return trainerInter.getingNewRequest(trainerName);
//    GET:
//            /trainerid/newrequests – новые заявки (фильтруются по параметру busy=true, confirmed = false).
//    Response: {courseid, name of the course, userid, user’s name, user’s surname, date, time }.
    }


    @PostMapping("/trainerid/newrequests/confirmation")
    public Integer confirmation(@RequestBody Schedule schedule) throws Exception {
        return trainerInter.confirmationRequest(schedule);

        //            /trainerid/newrequests/confirmation – подтверждение новой заявки

    }

    @GetMapping("admin/proposedcourses")
    public List<DtoGettingProposedCourse> newProposedCourse() {


        return courseServiceInt.getingProposedCourse();
        //admin/proposedcourses – получение новых заявок на новые курсы, фильтруется по параметру
    }


    @DeleteMapping("/admin/proposedcourses/reject/{coursename}")
    public Integer proposedCourseRejection(@PathVariable("coursename") String courseName) throws Exception {

        //            /admin/proposedcourses/reject – удаление предложения курса по нажатию «отклонить»

        return courseServiceInt.deletionProposedCourse(courseName);
    }

    @GetMapping("/trainerid/{trainerId}")
    public DtoGettingConfirmedRequests gettingConfirmedRequests(@PathVariable("trainerId") Integer trainerId) {


        return courseServiceInt.gettingConfirmedRequests(trainerId);
///trainerid/”текущая дата, от которой будет выстраиваться неделя” –

    }

    @GetMapping("/trainerid/courses/{email}")
    public List<DtoGettingCourcesOnTrainerId> gettingCourcesOnTrainerId(@PathVariable("email") String email) {
        //  подгрузка курсов, которые ведет тренер
        return trainerInter.getingCourseOnTrainerId(email);
    }


    @GetMapping("trainerid/schedule/")
    public List<DtoGettingCourcesOnTrainerId> gettingTrainersNameAndTheirNumberInScheduleTable(@RequestHeader("Authorization") String token) throws Exception {

        String email = tokenInter.checkToken(token);

        return trainerInter.gettingTrainersNameAndTheirNumberInScheduleTable(email);
    }


    @CrossOrigin
    @PostMapping("trainerid/addinterval/")
    public Integer addingInterval(@RequestBody Schedule schedule) throws Exception {
        ///trainerid/addinterval – непосредственно добавление интервала.
        return trainerInter.addingInterval(schedule);
    }


    @DeleteMapping("/trainerid/removeinterval/")
    public Integer deletionO(@RequestBody Schedule schedule) throws Exception {
        return trainerInter.deletionOfInterval(schedule);


        // /  /trainerid/removeinterval - удалить ранее заданное как свободное время, кнопочка на календаре
    }

    @CrossOrigin

    @PostMapping("/admin/addcourse")
    public DtoPostAddingCourse postAddingCourse(@RequestBody Course course) throws Exception {
        //    /admin/addcourse - добавить course и привязать его к тренеру:
        return courseServiceInt.addingCourse(course);
    }


    @DeleteMapping("/admin/removecourse/{name}")
    public Integer removeOfCourse(@PathVariable("name") String name) throws Exception {

        //    DELETE:
//            /admin/removecourse
        return courseServiceInt.removeCourse(name);


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

    @PostMapping("/topic")
    public int newTopic(@RequestBody TopicDTO topic) { //response create or no

        int responce = topicInterfaces.addNewTopic(topic);

        return responce;
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
