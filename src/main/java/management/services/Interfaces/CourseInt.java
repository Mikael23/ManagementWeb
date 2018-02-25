package management.services.Interfaces;

import management.DTO.CourseDateDTO;

import java.util.List;

public interface CourseInt {
    List<CourseDateDTO> getCourseSchedule(int courseId);
}
