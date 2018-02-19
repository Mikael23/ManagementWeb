package management.Service;

import management.entity.AddingCourse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface AddingCourseInt {




    int addCourse(AddingCourse course);
    Map<String,AddingCourse> li();
}
