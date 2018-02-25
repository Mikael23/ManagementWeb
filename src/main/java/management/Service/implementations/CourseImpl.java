package management.Service.implementations;

import management.DTO.CourseDateDTO;
import management.services.Interfaces.CourseInt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseImpl implements CourseInt {

    @Override
    public List<CourseDateDTO> getCourseSchedule(int courseId) {
        return null;
    }
}
