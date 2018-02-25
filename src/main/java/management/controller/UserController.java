package management.controller;


import management.DTO.*;
import management.services.Interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@RestController
@Singleton

public class UserController {

//  Mik's interfaces
    @Autowired
    UserService userService;


    @Autowired
    CourseService courseService;

    @Autowired
    AddingTrainer addingTrainer;
    @Autowired
    AddingCourseInt addingCourse;

//    Evgeniy's interfaces
    @Autowired
    TopicInt topicInterFace;

    @Autowired
    CourseInt courseInterfase;

    @Autowired
    UserInt userInterfase;

//    Evgeniy's methods

    @GetMapping("/top")
    public int getInt() {
        System.out.println(topicInterFace.getAllTopics() + "controller");
        return 1;

    }

    @GetMapping("/topics")
    public List<TopicDTO> getTopics() {

        return topicInterFace.getAllTopics();

    }

    @GetMapping("/topicsSwf")
    public List<TopicSwfDTO> getTopicsSwf() {

        return topicInterFace.getAllTopicsSwf();

    }

    @GetMapping("/{courseId}/datestimes")
    public List<CourseDateDTO> getDatesTimes(@PathVariable("courseId") Integer courseId) {

        return courseInterfase.getCourseSchedule(courseId);

    }

    @PostMapping("/course/choose")
    public ResponseEntity<String> saveUsersTimeCourse(@RequestBody  UsersCourseDTO chosenCourse){ //response create or no
        HttpStatus res = HttpStatus.OK;
        if(userInterfase.createUsersCourse(chosenCourse) == 1) {
            res = HttpStatus.NOT_MODIFIED;
        }

        return new ResponseEntity<String>(res);

    }

    @PutMapping("/{userid}/update")
    public ResponseEntity<Integer> updateUsersData(@PathVariable("userid") Integer userid, @RequestBody UserDTO user){

        return new ResponseEntity<Integer>(HttpStatus.OK);
    }

    @PostMapping("/Topic")
    public ResponseEntity<String> newTopic(@RequestBody  TopicDTO topic){ //response create or no
        int responce = topicInterFace.addNewTopic(topic);
        HttpStatus res = HttpStatus.OK;

        return new ResponseEntity<String>(res);

    }

    @GetMapping("/id")
    public Integer geting() {
        return 1;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {

        return userService.login(user);


    }



//  Mik's methods
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
