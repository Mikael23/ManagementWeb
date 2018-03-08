package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.ORM.entity.User;
import management.services.Interfaces.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserImplemen implements UserService {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<DtoGettingAllUserRecords> gettingAllUserRecords(Integer userId) {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public String addingTrainer(Trainer trainer) {
        return null;
    }

    @Override
    public DtoGettingThisDateN gettingDateOfUser(Integer id) {
        return null;
    }

    @Override
    public DTOlogging logging(User user) throws Exception {

        User user1 = em.find(User.class,user.email);
        if(user1==null){
            throw new Exception("please logg in");
        }

        String password = user1.password;
        String EnteredPassword = user.password;
        if(!password.equals(EnteredPassword)){
            throw new Exception("incorrect password");
        }

        DTOlogging dtOlogging = new DTOlogging();
        dtOlogging.role=user1.role;
        dtOlogging.name=user1.name;
        dtOlogging.surname=user1.surname;

        return dtOlogging;

    }

    @Override
    public DtoUpdatingProfile update(User user) {
        return null;
    }

    @Override
    public String choosingTime(Course course, String email) throws Exception {
        return null;
    }

    @Override
    public DTOlogging dtoLogging(User user) {

        return null;
    }

    @Override
    public DtoPuttingCancellTime puttingCancellTime(Course course, Integer userId) {
        return null;
    }

    @Override
    public DtoGettingThisDateN dtoGettinThisDateN(User user) {
        return null;
    }
   @Transactional
    @Override
    public DtoPostRegistration registration(User user) throws Exception {



        User user1=em.find(User.class,user.email);
        if(user1!=null){
            throw new Exception("We have got this user already");
        }
         System.out.println(user.id);
        String pas = user.password;
        String repeatOfPas = user.repeatPassword;
        if(!pas.equals(repeatOfPas)){
            throw new Exception("The passwords are not equals");
        }

       if (pas.length() < 8) {
           throw new Exception("No enough of numbers in password");
       } else {
           char c;
           int count = 0;
           for (int i = 0; i < pas.length(); i++) {
               c = pas.charAt(i);
               if (!Character.isLetterOrDigit(c)) {
                   throw new Exception("The symbol not correct");
               } else if (Character.isDigit(c)) {
                   count++;
               }
           }
           if (count < 2)   {
               throw new Exception("No enough of numbers");
           }
       }




       em.persist(user);
       DtoPostRegistration dtoPostRegistration = new DtoPostRegistration();
       dtoPostRegistration.role = user.role;
       dtoPostRegistration.login=user.email;
       dtoPostRegistration.role="User";



        return dtoPostRegistration;
    }
}
///registration
//        Body:  {name, surname, email, password, repeatpassword, phone, dateofbirth,
//        city – заполнение всех полей обязательно; skype, viber, whatsapp, telegram,
//        vk, facebook, instagram – не обязательно}, role=user}
//        Response: назначить id юзеру – userid, направление на страницу, с которой был запуск регистрации,
//        назначить role – по умолчанию всегда user (на trainer может изменить администратор).
