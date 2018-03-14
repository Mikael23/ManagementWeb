package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.AllUsers;
import management.services.Interfaces.CourseServiceInt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
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

    @Transactional
    @Override
    public Integer removeCourse(Integer courseId) throws Exception {
        //   String jpql = "Select r from Course r where confirmed = false";
        String jpql = "Select r from Course r where confirmed=true";

        String jpql2 = "Select r from Trainer r";

        List<Trainer> listOfTrainers = em.createQuery(jpql2, Trainer.class).getResultList();

        List<Course> listOfCourses = em.createQuery(jpql, Course.class).getResultList();
        String name = null;

        if (listOfCourses == null) {
            throw new Exception("401, nothing to remove");
        }
        for (Course course : listOfCourses) {
            if (course.id == courseId){

                name = course.nameOfCourse;


            }
        }


        Course course = em.find(Course.class, name);

        for (Trainer trainer : listOfTrainers) {
            if (trainer.listOfCources.contains(course)) {
                System.out.println(trainer.listOfCources.contains(course));
                Integer in = trainer.listOfCources.indexOf(course);
                trainer.listOfCources.remove(course);

                return 200;


            }
        }

       // em.remove(course);




        return 401;

    }

    @Override
    @Transactional
    public DtoPostAddingCourse addingCourse(Course course) throws Exception {


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


        Trainer trainer = new Trainer();
        trainer.email = course1.trainerName;


        trainer = em.find(Trainer.class, trainer.email);
        if (trainer == null) {
            throw new Exception("Sorry we dont have this trainer in our list");
        }
        em.remove(trainer);
        trainer.nameOfCourse = course1.nameOfCourse;
        trainer.listOfCources.add(course1);
        em.persist(trainer);
        course1.confirmed = true;
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
    @Transactional
    public Integer deletionProposedCourse(String courseName) throws Exception {

        List<Course> cources = new ArrayList<>();

        String jpql = "Select r from Course r where confirmed = false";


        cources = em.createQuery(jpql, Course.class).getResultList();
        if (cources == null) {
            throw new Exception("There is nothing to remove, 401");
        }

        for (Course course : cources) {
            System.out.println(course.nameOfCourse);
            if (course.nameOfCourse.equals(courseName)) {
                System.out.println("Udalyaem");
                Course course1 = em.find(Course.class, courseName);
                em.remove(course1);
            }
        }


        return 200;
    }

    @Override
    public List<DtoGettingProposedCourse> getingProposedCourse() {
        List<Course> list = new ArrayList<>();

        String jpql = "SELECT r FROM Course r where confirmed=false";
        list = em.createQuery(jpql, Course.class).getResultList();


        List<DtoGettingProposedCourse> list1 = new ArrayList<>();


        for (Course course : list) {
            DtoGettingProposedCourse dtoGettingProposedCourse = new DtoGettingProposedCourse();
            dtoGettingProposedCourse.description = course.description;
            dtoGettingProposedCourse.duration = course.duration;
            dtoGettingProposedCourse.nameOfCourse = course.nameOfCourse;
            System.out.println(dtoGettingProposedCourse.nameOfCourse);
            dtoGettingProposedCourse.quantity = course.quantity;
            dtoGettingProposedCourse.yourname = course.initiatorCourse;
            dtoGettingProposedCourse.phone = course.phoneInitiator;
            list1.add(dtoGettingProposedCourse);
        }


        return list1;

    }

    @Override
    @Transactional
    public int proposeCourse(Course course) throws Exception {

        Course course1 = new Course();
        String name = course.nameOfCourse;
        AllUsers allUsers1 = new AllUsers();
        allUsers1.email = course.initiatorCourse;

        AllUsers allUsers = em.find(AllUsers.class, allUsers1.email);

        if (allUsers == null) {

            throw new Exception("You have to log in before proposing the course");
        }

        course1.nameOfCourse = course.nameOfCourse;

        Course course2 = em.find(Course.class, course1.nameOfCourse);
        if (course2 != null) {

            name = course1.nameOfCourse + "2";
            course.nameOfCourse = name;
            em.persist(course);
            return 200;

        }
        course1.nameOfCourse = name;
        course1.description = course.description;
        course1.duration = course.duration;
        course1.quantity = course.quantity;
        course1.initiatorCourse = course.initiatorCourse;
        course1.phoneInitiator = course.phoneInitiator;
        course1.confirmed = false;
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
