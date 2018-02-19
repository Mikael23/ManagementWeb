package management.Service;

import management.controller.UserController;
import management.entity.AddingCourse;
import management.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AddingCourseImplem implements AddingCourseInt {

    private final AtomicInteger idCounter = new AtomicInteger();
    private Map<String, AddingCourse> addedCourse = new HashMap<String, AddingCourse>();
    public  AddingTrainerImplement trainers = new AddingTrainerImplement();


   @Autowired
    UserController us;



    public int addCourse(AddingCourse course) {

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


        course.trainer = trainer;





        addedCourse.put(course.name,course);



        return id;
    }

    @Override
    public Map<String, AddingCourse> li() {
        return addedCourse;
    }


}
