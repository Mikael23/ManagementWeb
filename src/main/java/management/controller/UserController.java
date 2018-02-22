package management.controller;


import management.DTO.*;
import management.services.Interfaces.AddingCourseInt;
import management.services.Interfaces.AddingTrainer;
import management.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import management.services.Interfaces.CourseService;

import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@RestController
@Singleton

public class UserController {




    @Autowired
    UserService userService;


    @Autowired
    CourseService courseService;

    @Autowired
    AddingTrainer addingTrainer;
    @Autowired
    AddingCourseInt addingCourse;

    @GetMapping("/id")
    public Integer geting() {
        return 1;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {

        return userService.login(user);


    }




    @GetMapping("/Trainers")
    public Map<String, Trainer> GetTrainers() {
        return addingTrainer.getTrainers();
    }


    @GetMapping("/gettingCources")
    public Map<String, Course> course() {
        return addingCourse.li();
    }


    @GetMapping("/gettingTrainer/{name}")
    public Trainer gettingTrainer(@PathVariable("name") String name) {
        Trainer trainer = addingTrainer.gettingTrainer(name);
        return trainer;
    }

    @PostMapping("/trainer")
    public Integer addingTrainer(@RequestBody Trainer trainer) {

        return addingTrainer.addingTrainer(trainer);
    }


    @PostMapping("/user")
    public ResponseEntity save(@RequestBody User user) {


        int id = userService.save(user);
        System.out.println("rrrr");
        return ResponseEntity.ok().body("new user created with id" + id);

    }

    @PostMapping("/proposeCourse")
    public Integer ProposeCourse(@RequestBody Course course) {

        return courseService.proposeCourse(course);
    }

    @PostMapping("/addingCourse")
    public Integer AddingCourse(@RequestBody Course course) {
        return addingCourse.addCourse(course);
    }

    @GetMapping("/allProposedCourses")
    public Map<String, Course> allProposedCourses() {
        return courseService.gettingProposedCources();
    }

    @DeleteMapping("admin/suggestedcourses/delete/{name}/{id}")
    public String deletedSuggestedCources(@PathVariable("name")String name, @PathVariable("id") int id){
    return courseService.deletedSuggestedCources(id,name);
    }


    @GetMapping ("trainerid/getCources/{name}")
    public List<String> listOfCources(@PathVariable("name")String name){


        Trainer trainer = addingTrainer.gettingTrainer(name);

        List<String> cource = addingTrainer.listOfcources(trainer);

        return cource;
    }


    @PostMapping("/trainerid/addinterval/")
    public double[] AddIntervals(@RequestBody Course course){

        double [] eq =       addingTrainer.addingSuggestedCourseInterval(course);
        return eq;
    }





    @DeleteMapping("/trainerid/deleteinterval/{name}")
    public double[] deleteInterval(@PathVariable("name")String name){


        return addingTrainer.deletionOfInterval(name);



    }


    @PostMapping("/courseid/choose/{name}")
    public List<Course> choosingTime(@PathVariable("name") String name, @RequestBody Course course){




        return userService.choosingTime(name,course);




    }


//    trainerid/deleteinterval - удалить ранее
//    заданное как свободное время, кнопочка на календаре
//    Body: {intervalid: delete}
//    Response: 200 or 401

///courseid/choose - запись на курс на конкретное время
//    Body: {request: {courseid, userid, chosendate, chosentime, note, confirmed = false}}
//    Response: вернуть ошибку, если пользователь уже записан на это время
//    Если все успешно, данные дата и время попадают в неподтвержденные записи
//    у администратора, и как неподтвержденные - в личный кабинет пользователя, тренеру отправляется
//    оповещение на e-mail о новой записи. Выбранное время перестает быть свободным. В базу данных заносится
//    параметр confirmed = false, который поменяется на true после подтверждения. У интервала по intervalid значение busy меняется на true.
//    Заявке присваивается id - requestid.



}
