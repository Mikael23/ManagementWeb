package management.Service;

import management.entity.AddingCourse;
import management.entity.ProposeCourse;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {



    int proposeCourse(ProposeCourse course);

}


