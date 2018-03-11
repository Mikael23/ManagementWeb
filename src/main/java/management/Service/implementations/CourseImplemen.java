package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.User;
import management.services.Interfaces.CourseServiceInt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CourseImplemen implements CourseServiceInt {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger();


    @PersistenceContext
    EntityManager em;

    @Override
    public DtoGettingCancelledRequest gettingCancelledRequest() {
        return null;
    }

    @Override
    public Integer deletionCancelledrecords(Integer courseId) {
        return null;
    }

    @Override
    public Integer removeCourse(Integer courseId) {
        return null;
    }

    @Override
    @Transactional
    public DtoPostAddingCourse addingCourse(Course course) throws Exception {
///admin/addcourse - добавить course и привязать его к тренеру:

        Integer id = ID_GENERATOR.getAndIncrement();
        Course course1 = new Course();
        course1.id = id;
        course1.nameOfCourse = course.nameOfCourse;
        course1.description = course.description;
        course1.trainerName = course.trainerName;
        course1.duration = course.duration;
        course1.quantatity = course.quantatity;
        course1.kindOfCourse = course.kindOfCourse;

        Course course2 = em.find(Course.class, course.nameOfCourse);
        System.out.println(course2);
        if (course2 != null) {
            throw new Exception("We have had already this nameOfCourse");
        }

        Trainer trainer = new Trainer();
        trainer.email=course1.trainerName;


        trainer = em.find(Trainer.class,trainer.email);
        if(trainer==null){
            throw new Exception("Sorry we dont have this trainer in our list");
        }
        em.remove(trainer);
        trainer.nameOfCourse=course1.nameOfCourse;
        trainer.listOfCources.add(course1);
        em.persist(trainer);

        em.persist(course1);
        DtoPostAddingCourse dtoPostAddingCourse = new DtoPostAddingCourse();
        dtoPostAddingCourse.setCourseId(course1.id);
        dtoPostAddingCourse.setTrainerIdl(1);
        return dtoPostAddingCourse;
    }

    @Override
    public DtoGettingConfirmedRequests gettingConfirmedRequests(Integer trainerId) {
        return null;
    }

    @Override
    public Integer deletionProposedCourse(Integer courseId) {
        return null;
    }

    @Override
    public List<DtoGettingProposedCourse> getingProposedCourse() {
        return null;
    }

    @Override
    @Transactional
    public int proposeCourse(Course course) throws Exception {

        Course course1 = new Course();

        User user1 = new User();
        user1.email = course.initiatorCourse;

        User user = em.find(User.class,user1.email);

        if(user==null){

            throw new Exception("You have to log in before proposing the course");
        }

        course1.nameOfCourse = course.nameOfCourse;

        Course course2 = em.find(Course.class,course1.nameOfCourse);
        if(course2!=null){
            throw new Exception("Please change the name of course");
        }
        course1.description = course.description;
        course1.duration = course.duration;
        course1.quantity = course.quantity;
        course1.initiatorCourse = course.initiatorCourse;
        course1.phoneInitiator = course.phoneInitiator;
        course1.confirmed = true;
        em.persist(course1);

        return 200;
    }

    @Override
    public Map<String, Course> gettingProposedCources() {
        return null;
    }

    @Override
    public String deletedSuggestedCources(int id, String name) {
        return null;
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public Map<String, Course> li() {
        return null;
    }

    @Override
    public CourseDateAndTimesResponse gettingFreeTimesandDuration(Integer id) throws Exception {
        return null;
    }

    @Override
    public String choosingAndBookingforCourse(Course course) {
        return null;
    }
}
