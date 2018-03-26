package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Schedule;
import management.ORM.entity.Trainer;
import management.ORM.entity.AllUsers;
import management.services.Interfaces.TrainerInter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
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

    @Transactional
    @Override
    public Integer addingInterval(Schedule schedule) throws Exception {

        String courseName = schedule.coursename;

        Course course = em.find(Course.class, courseName);

        if(course==null){
            throw new Exception("No found course");
        }

        Schedule schedule1 = new Schedule();

        String dateTime = schedule.data;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTime, formatter);


        String trainerName = schedule.trainerName;
        Trainer trainer = em.find(Trainer.class, trainerName);
        System.out.println(dateTime1);


        schedule1.dates.add(dateTime1);
        schedule1.dt = dateTime1;
        schedule1.busy = false;
        schedule1.coursename = course.nameOfCourse;
        schedule1.trainerName = trainer.email;
        em.persist(schedule1);



//        Поля дата, время, подгруженные курсы (которые можно выбрать галочками).
//                Кнопка «добавить» запоминает выбранное и отображает в соседней форме.
//                Поля дата, время, галочки на выбранных курсах обнуляются, чтобы можно было добавить еще один интервал.
//        По кнопке «сохранить» выполняется запрос.
//        Body: interval: date, массив из {time, {массив выбранных courseid}, busy=false}.
//
//        String str = "1986-04-08 12:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);


        return 200;
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
    public List<DtoGettingNewRequets> getingNewRequest(String name) {
      //  String jpql = String.format("SELECT r FROM Schedule r where r.busy=false and r.coursename ='" + name + "'",Schedule.class);

    String jpql =
            String.format("SELECT r FROM Schedule r where r.busy=true and r.confirmedByTrainer=false and r.trainerName=' " + name + " '", Schedule.class);

    List<Schedule>listoftrainers = em.createQuery(jpql,Schedule.class).getResultList();

    System.out.println(name);
 List<DtoGettingNewRequets>dtoGettingNewRequets = new LinkedList<>();
 DtoGettingNewRequets dtoGettingNewRequets1=new DtoGettingNewRequets();

        for (Schedule schedule:listoftrainers) {
       System.out.println(schedule.confirmedByTrainer);
            dtoGettingNewRequets1.NameOfCourse=schedule.coursename;
            dtoGettingNewRequets1.userName=schedule.requestedUser;
            dtoGettingNewRequets1.courseId=schedule.id;
            dtoGettingNewRequets1.localDateTime=schedule.dt;
            dtoGettingNewRequets.add(dtoGettingNewRequets1);


        }


//        GET:
///trainerid/newrequests – новые заявки (фильтруются по параметру busy=true, confirmed = false).
//        Response: {courseid, name of the course, userid, user’s name, user’s surname, date, time }.
//        PUT:

        return dtoGettingNewRequets;
    }

    @Override
    @Transactional
    public Integer addingTrainer(Trainer trainer) throws Exception {
        String name = trainer.email;

        AllUsers allUsers = em.find(AllUsers.class, name);
        if (allUsers == null) {
            throw new Exception("We dont have this allUsers in base");
        }

        em.remove(allUsers);
        allUsers.role = "trainer";
        em.persist(allUsers);


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
    public DtoAddingToWaitingLis addToWaitingList(AllUsers allUsers) {
        return null;
    }

    @Override
    public DtoGettingDatesAndTimes gettingDatesAndTimes(String name) {

        Schedule schedule = new Schedule();
//        String jpql=String.format("select r from Record r where "
//                + "r.book.isbn=%d and r.reader.id=%d", isbn,readerId);
        // String jpql = "Select r from Course r where confirmed = false";


//        TypedQuery<CompanyEntity> query =
//                em.createQuery("SELECT c FROM CompanyEntity AS c WHERE c.name='" + inputName + "'", CompanyEntity.class);



        String jpql = String.format("SELECT r FROM Schedule r where r.busy=false and r.coursename ='" + name + "'",Schedule.class);

        List<Schedule> schedules = em.createQuery(jpql, Schedule.class).getResultList();
        DtoGettingDatesAndTimes dtoGettingDatesAndTimes = new DtoGettingDatesAndTimes();
        for (Schedule schedule1 : schedules) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime dateTime = schedule1.dt;


            String formattedDateTime = dateTime.format(formatter);

            dtoGettingDatesAndTimes.datesandTimes.add(formattedDateTime);
            dtoGettingDatesAndTimes.trainerName.add(schedule1.trainerName);
            System.out.println(schedule1.id);
            dtoGettingDatesAndTimes.setsId.add(schedule1.id);

        }



        return dtoGettingDatesAndTimes;
    }

    @Override
    public List<DtoGettingTrainers> getTrainers() {

        List<Trainer> listOfTrainers = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        List<DtoGettingTrainers> dtoGettingTrainersList = new ArrayList<>();


        String jpql = "SELECT r FROM Trainer r";
        listOfTrainers = em.createQuery(jpql, Trainer.class).getResultList();

        for (Trainer trainer : listOfTrainers) {
            DtoGettingTrainers dtoGettingTrainers = new DtoGettingTrainers();
            System.out.println(trainer.name);
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
    public List<String> returningTrainerNames() {

        String jpql = "SELECT r FROM Trainer r";

        List<Trainer> listOfNameOfTrainers = em.createQuery(jpql, Trainer.class).getResultList();
        List<String> trainerNames = new ArrayList<>();

        for (Trainer trainer : listOfNameOfTrainers) {
            trainerNames.add(trainer.email);
        }


        return trainerNames;
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

    @Transactional
    @Override
    public Integer makerTrainer(String userName) throws Exception {


        AllUsers allUsers = em.find(AllUsers.class, userName);
        if (allUsers == null) {
            throw new Exception("We dont have this allUsers");
        }

        Trainer trainer = new Trainer();
        em.remove(allUsers);
        trainer.email = allUsers.email;
        trainer.surname = allUsers.surname;
        trainer.name = allUsers.name;

        allUsers.role = "trainer";

        em.persist(trainer);
        em.persist(allUsers);

        return 200;
    }
}
