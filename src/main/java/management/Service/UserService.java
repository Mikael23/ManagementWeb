package management.Service;

import management.entity.LoginUser;
import management.entity.ProposeCourse;
import management.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int save(User user);
    boolean login(LoginUser user);


}



