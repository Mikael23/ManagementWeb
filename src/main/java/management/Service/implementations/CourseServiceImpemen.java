package management.Service.implementations;

import management.DTO.Course;
import management.services.Interfaces.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class CourseServiceImpemen implements CourseService {



    private final AtomicInteger idCounter = new AtomicInteger();
    private Map<String,Course> courses = new HashMap<>();
    private Map<String,Course> Addedcourses = new HashMap<String, Course>();




    public int proposeCourse(Course course) {

     System.out.println(course.Coursename);

            if (courses.containsKey(course.Coursename)){
                return 401;
            }
            int id = idCounter.getAndIncrement();
            course.id=id;
            courses.put(course.Coursename,course);
            return id;
        }

    @Override
    public Map<String, Course> gettingProposedCources() {
        return courses;
    }

    @Override
    public String deletedSuggestedCources(int id,String name) {

        Course course = courses.get(name);

        if(course.id==id){
            courses.remove(name);
            return "Deleted";
        }





        return "No object";




    }

    public int addCourse(Course course) {





        return 0;
    }


///admin/addcourse - добавить курс на страницу курсов:
//        Body: {course: {name, description, picture, trainerid, duration,
//        quantity (максимальное количество записей на сессию)}}
//        Response: добавить курс в массив courses, назначить id курсу и связать
//        его c trainerid (добавить в массив courses: {} у trainerid courseid).
//        Если trainerid – несколько, то курсу назначается два courseid.





}
