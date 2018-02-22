package management.services.Interfaces;

import management.DTO.Course;
import management.DTO.Trainer;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Service
public interface AddingTrainer {


  Integer  addingTrainer(Trainer trainer);
   Trainer gettingTrainer(String name);
    Map<String, Trainer> getTrainers();
    List<String> listOfcources(Trainer trainer);
    double[] deletionOfInterval(String name);
    double[]addingSuggestedCourseInterval(Course course);



    //    POST:
//            /admin/addtrainer - добавить тренера на страницу тренеров:
//    Body: {name, description, photo}
//    Response: 200 or 401

}
