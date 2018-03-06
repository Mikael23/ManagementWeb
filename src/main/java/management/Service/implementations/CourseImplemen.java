package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.User;
import management.services.Interfaces.CourseServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DtoPostAddingCourse addingCourse(Course course) {

        Integer id = ID_GENERATOR.getAndIncrement();
        Course course1 = new Course();
        course1.id = id;
        course1.nameOfCourse = course.nameOfCourse;
        course1.description = course.description;
        course1.trainerName = course.trainerName;
        course1.duration = course.duration;
        course1.quantatity = course.quantatity;
        course1.kindOfCourse=course.kindOfCourse;




//        Body: {courseid, name of the course, description, trainerid, duration,
//                quantity (максимальное количество записей на сессию), confirmed = true}
//        Response: courseid связать с trainerid , поля yourname и phone удалить, поле confirmed поменять на true.
//                Ошибка может быть в случае, если такой courseid уже существует.



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
