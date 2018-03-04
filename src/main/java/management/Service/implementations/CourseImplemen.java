package management.Service.implementations;

import management.DTO.*;
import management.ORM.Course;
import management.ORM.Trainer;
import management.ORM.User;
import management.services.Interfaces.CourseServiceInt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class CourseImplemen implements CourseServiceInt {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger();

    @PersistenceContext
            //new
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
    public DtoPostAddingCourse addingCourse(Course course) {

        Integer id = ID_GENERATOR.getAndIncrement();
        Course course1 = new Course();
        course1.id = id;
        course1.name = course.name;
        course1.description = course.description;
        course1.trainerName = course.trainerName;
        course1.duration = course.duration;
        course1.quantatity = course.quantatity;

       Trainer trainer =  em.find(Trainer.class,course.trainerName);
       trainer.listOfCources.add(course1);
       em.persist(course1);
       em.persist(trainer);

        return null;
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
    public int proposeCourse(Course course, User user) {
        return 0;
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
