package management.Service;

import management.entity.AddingCourse;
import management.entity.ProposeCourse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class CourseServiceImpemen implements CourseService {



    private final AtomicInteger idCounter = new AtomicInteger();
    private Map<String,ProposeCourse> courses = new HashMap<String, ProposeCourse>();
    private Map<String,AddingCourse> Addedcourses = new HashMap<String, AddingCourse>();




    public int proposeCourse(ProposeCourse course) {

     System.out.println(course.Coursename);

            if (courses.containsKey(course.Coursename)){
                return 401;
            }
            int id = idCounter.getAndIncrement();
            course.idCourse=id;
            courses.put(course.Coursename,course);
            return id;
        }

    public int addCourse(AddingCourse course) {





        return 0;
    }


///admin/addcourse - добавить курс на страницу курсов:
//        Body: {course: {name, description, picture, trainerid, duration,
//        quantity (максимальное количество записей на сессию)}}
//        Response: добавить курс в массив courses, назначить id курсу и связать
//        его c trainerid (добавить в массив courses: {} у trainerid courseid).
//        Если trainerid – несколько, то курсу назначается два courseid.





}

