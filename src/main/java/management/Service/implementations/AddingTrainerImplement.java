package management.Service.implementations;

import management.DTO.Course;
import management.DTO.Trainer;
import management.services.Interfaces.AddingCourseInt;
import management.services.Interfaces.AddingTrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class AddingTrainerImplement implements AddingTrainer {


    private final AtomicInteger idCounter = new AtomicInteger();
    public final Map<String, Trainer> trainers = new HashMap<>();

    @Autowired
    AddingCourseInt courseService;




    public Integer addingTrainer(Trainer trainer) {

        int id = idCounter.getAndIncrement();
        trainer.id = id;
//        for(Trainer trainerr: trainers.values()){
//            System.out.println(trainerr.toString());
//        }
        if (trainers.containsKey(trainer.name)) {
            return 401;
        }


        trainers.put(trainer.name, trainer);
        Trainer trainerr = trainers.get(trainer.name);





        return id;
    }


    public Trainer gettingTrainer(String name){


       Trainer trainer = trainers.get(name);



        for(String namee: trainers.keySet()){
            System.out.println("vot" + namee);
        }


        System.out.println(trainer.toString());
       return trainer;

    }

    @Override
    public Map<String, Trainer> getTrainers()
    {
        return trainers;
    }




    @Override
    public List<String> listOfcources(String name) {
        List<String>cources = new ArrayList<>();
          for(Course namee:courseService.li().values()){
              if(namee.equals(namee)){
                  cources.add(namee.Coursename);
              }
          }
          return cources;
    }


}
//POST:
//        /admin/addtrainer - добавить тренера на страницу тренеров:
//        Body: {name, description, photo}
//        Response: 200 or 401
