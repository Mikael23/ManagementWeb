package management.services.Interfaces;

import management.DTO.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AddingTrainer {


  Integer  addingTrainer(Trainer trainer);
   Trainer gettingTrainer(String name);
    Map<String, Trainer> getTrainers();
    List<String> listOfcources(String name);


    //    POST:
//            /admin/addtrainer - добавить тренера на страницу тренеров:
//    Body: {name, description, photo}
//    Response: 200 or 401

}
