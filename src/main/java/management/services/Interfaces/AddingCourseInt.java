package management.services.Interfaces;

import management.DTO.Course;
import management.DTO.CourseDateAndTimesResponse;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface AddingCourseInt {




    int addCourse(Course course);
    Map<String,Course> li();
    CourseDateAndTimesResponse gettingFreeTimesandDuration(Integer id) throws Exception;

}
