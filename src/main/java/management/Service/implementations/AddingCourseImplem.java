package management.Service.implementations;

import management.DTO.Course;
import management.DTO.CourseDateAndTimesResponse;
import management.controller.UserController;
import management.DTO.Trainer;
import management.services.Interfaces.AddingCourseInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AddingCourseImplem implements AddingCourseInt {

    private final AtomicInteger idCounter = new AtomicInteger();
    private Map<String, Course> addedCourse = new HashMap<String, Course>();
    public  AddingTrainerImplement trainers = new AddingTrainerImplement();


   @Autowired
    UserController us;




    public int addCourse(Course course) {

        Integer id = idCounter.getAndIncrement();

        if(addedCourse.containsKey(id)){
            return 401;
        }


        System.out.println(course.trainerName);



        Trainer trainer = us.gettingTrainer(course.trainerName);

   //     System.out.println(trainer.toString());
    //    System.out.println(course.trainerName);


        if(trainer==null){
            return 500;
        }


        course.trainerName = trainer.name;





        addedCourse.put(course.name,course);



        return id;
    }

    @Override
    public Map<String, Course> li() {
        return
                addedCourse;
    }


    public CourseDateAndTimesResponse gettingFreeTimesandDuration(Integer courseId) throws Exception {

        CourseDateAndTimesResponse courseDateAndTimesResponse = new CourseDateAndTimesResponse();
        System.out.println(courseId);
        for(Course course:addedCourse.values()){
            if(courseId.equals(course.id)){
                courseDateAndTimesResponse.quantity = course.quantity;
                System.out.println(courseDateAndTimesResponse.quantity);

                courseDateAndTimesResponse.suggestedTimes = course.SuggestedTimes;
                System.out.println(courseDateAndTimesResponse.suggestedTimes);
                courseDateAndTimesResponse.trainerName = course.trainerName;
                System.out.println(courseDateAndTimesResponse.trainerName);
                courseDateAndTimesResponse.name = course.name;
            }
        }

        if(courseDateAndTimesResponse==null){
            throw new Exception("Not Found");
        }

       return courseDateAndTimesResponse;
    }


}
