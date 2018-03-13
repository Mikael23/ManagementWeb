package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.User;
import management.services.Interfaces.TrainerInter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TrainerImplemen implements TrainerInter {


    private static AtomicInteger ID_GENERATOR = new AtomicInteger();


    @PersistenceContext
    EntityManager em;

    @Override
    public List<DtoGettingCourcesOnTrainerId> getingCourseOnTrainerId(Integer id) {
        return null;
    }

    @Override
    public Integer deletionFreeTimeInterval(Course course, Integer trainerId) {
        return null;
    }

    @Override
    public Integer addingInterval(Integer id, Course course) {
        return null;
    }

    @Override
    public DtoGettingTrainers gettingTrainers(String email) {
        return null;
    }

    @Override
    public Integer rejectionRequest(Integer id, Course course) {
        return null;
    }

    @Override
    public Integer confirmationRequest(Course course) {
        return null;
    }

    @Override
    public DtoGettingNewRequets getingNewRequest(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public Integer addingTrainer(Trainer trainer) throws Exception {
        String name = trainer.email;

        User user = em.find(User.class,name);
        if(user==null){
            throw new Exception("We dont have this user in base");
        }

        em.remove(user);
        user.role="trainer";
        em.persist(user);


        Trainer trainer2 = em.find(Trainer.class, trainer.email);
        if (trainer2 != null) {
            System.out.println("We have already got this trainer");
            return 401;
        }




        Course course = new Course();


        em.persist(trainer);


        Trainer trainer1 = em.find(Trainer.class, trainer.email);

        if (trainer1 == null) {
            System.out.println("We couldnt add the trainer");
            return 401;
        }

        return 200;
    }

    @Override
    public Trainer gettingTrainer(String name) {
        return null;
    }

    @Override
    public List<DtoGettingWaitingList> gettingWaitingList(Integer id) {
        return null;
    }

    @Override
    public DtoAddingToWaitingLis addToWaitingList(User user) {
        return null;
    }

    @Override
    public DtoGettingDatesAndTimes gettingDatesAndTimes(Integer id) {
        return null;
    }

    @Override
    public List<DtoGettingTrainers> getTrainers() {

        List<Trainer> listOfTrainers = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();
        DtoGettingTrainers dtoGettingTrainers = new DtoGettingTrainers();
        List<DtoGettingTrainers> dtoGettingTrainersList = new ArrayList<>();


        String jpql = "SELECT r FROM Trainer r";
        listOfTrainers = em.createQuery(jpql, Trainer.class).getResultList();

        for (Trainer trainer : listOfTrainers) {
            dtoGettingTrainers.description = trainer.description;
            dtoGettingTrainers.name = trainer.name;
            System.out.println(trainer.listOfCources.toString());

            for (Course nameOfCourse : trainer.listOfCources) {
                System.out.println("hello");
                System.out.println(nameOfCourse);
                dtoGettingTrainers.nameOfCources.add(nameOfCourse.nameOfCourse);
            }

            dtoGettingTrainersList.add(dtoGettingTrainers);

        }


        return dtoGettingTrainersList;
    }

    @Override
    public DtoCancellation cancellation(String messageToUser) {
        return null;
    }

    @Override
    public List<String> listOfcources(Trainer trainer) {
        return null;
    }

    @Override
    public double[] deletionOfInterval(String name) {
        return new double[0];
    }

    @Override
    public double[] addingSuggestedCourseInterval(Course course) {
        return new double[0];
    }
}
