package management.controller;


import management.Service.*;
import management.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//
//@PostMapping("/book")
//public ResponseEntity<?> save(@RequestBody Book book) {
//        long id = bookService.save(book);
//        return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
//        }


//
//@POST
//public String add(UniversityCreationRequest req) throws SQLException, ExecutionException, InterruptedException {
//
//        String id = universityService.add(req.name, req.city, req.address);
//
//        return id;
//        }


import management.Service.CourseService;

import javax.inject.Singleton;
import java.util.ArrayList;
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
    public boolean login(@RequestBody LoginUser user) {

        return userService.login(user);


    }




    @GetMapping("/gettingCources")
    public Map<String, AddingCourse> course() {
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
    public Integer ProposeCourse(@RequestBody ProposeCourse course) {

        return courseService.proposeCourse(course);
    }

    @PostMapping("/addingCourse")
    public Integer AddingCourse(@RequestBody AddingCourse course) {
        return addingCourse.addCourse(course);
    }


}
