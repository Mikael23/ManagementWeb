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




//
//    DELETE:
//            /admin/suggestedcourses/delete – удаление предложения курса по нажатию «отклонить»
//    Body: {suggestedcourseid : delete}
//    Response: 200 or 401


}
