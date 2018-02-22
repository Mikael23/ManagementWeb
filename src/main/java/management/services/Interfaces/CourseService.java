package management.services.Interfaces;

import management.DTO.Course;
import management.DTO.CourseResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CourseService {


    CourseResponse courseresponse()
    int proposeCourse(Course course);
    Map<String,Course> gettingProposedCources();
    String deletedSuggestedCources(int id,String name);

}


