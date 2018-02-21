package management.services.Interfaces;

import management.DTO.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int save(User user);
    boolean login(User user);
    User update(User user);



}



///trainerid/update – обновляет информацию профиля пользователя
//        Body: {name, surname, old password, new password, repeat new password, phone,
//        city, skype, viber, whatsapp, telegram, vk, facebook, instagram }
