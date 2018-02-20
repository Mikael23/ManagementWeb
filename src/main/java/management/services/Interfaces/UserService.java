package management.services.Interfaces;

import management.DTO.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int save(User user);
    boolean login(User user);


}



