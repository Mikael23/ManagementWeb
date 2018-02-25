package management.services.Interfaces;

import management.DTO.UserDTO;
import management.DTO.UsersCourseDTO;

public interface UserInt {
    int createUsersCourse(UsersCourseDTO course);
    int updateUserData(UserDTO user);
}
