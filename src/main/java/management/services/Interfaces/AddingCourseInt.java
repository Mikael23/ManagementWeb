package management.services.Interfaces;

import management.DTO.Course;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface AddingCourseInt {




    int addCourse(Course course);
    Map<String,Course> li();
}
