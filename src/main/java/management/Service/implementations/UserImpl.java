package management.Service.implementations;

import management.DTO.UserDTO;
import management.DTO.UsersCourseDTO;
import management.services.Interfaces.UserInt;
import org.springframework.stereotype.Repository;

@Repository
public class UserImpl implements UserInt {
    @Override
    public int createUsersCourse(UsersCourseDTO course) {
        return 0;
    }

    @Override
    public int updateUserData(UserDTO user) {
        return 0;
    }
}
