package management.Service.implementations;

import management.DTO.*;
import management.ORM.entity.AllUsers;
import management.ORM.entity.Course;
import management.ORM.entity.Trainer;
import management.services.Interfaces.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public int save(AllUsers allUsers) {
        return 0;
    }

    @Override
    public boolean login(AllUsers allUsers) {
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
    public DTOlogging logging(AllUsers allUsers) throws Exception {

        AllUsers allUsers1 = em.find(AllUsers.class, allUsers.email);
        if(allUsers1 ==null){
            throw new Exception("please logg in");
        }

        String password = allUsers1.password;
        String EnteredPassword = allUsers.password;
        if(!password.equals(EnteredPassword)){
            throw new Exception("incorrect password");
        }

        DTOlogging dtOlogging = new DTOlogging();
        dtOlogging.role= allUsers1.role;
        dtOlogging.name= allUsers1.name;
        dtOlogging.surname= allUsers1.surname;

        return dtOlogging;

    }

    @Override
    public DtoUpdatingProfile update(AllUsers allUsers) {
        return null;
    }

    @Override
    public String choosingTime(Course course, String email) throws Exception {
        return null;
    }

    @Override
    public DTOlogging dtoLogging(AllUsers allUsers) {

        return null;
    }

    @Override
    public DtoPuttingCancellTime puttingCancellTime(Course course, Integer userId) {
        return null;
    }

    @Override
    public DtoGettingThisDateN dtoGettinThisDateN(AllUsers allUsers) {
        return null;
    }
   @Transactional
    @Override
    public DtoPostRegistration registration(AllUsers allUsers) throws Exception {



        AllUsers allUsers1 =em.find(AllUsers.class, allUsers.email);
        if(allUsers1 !=null){
            throw new Exception("We have got this allUsers already");
        }
         System.out.println(allUsers.id);
        String pas = allUsers.password;
        String repeatOfPas = allUsers.repeatPassword;
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




       em.persist(allUsers);
       DtoPostRegistration dtoPostRegistration = new DtoPostRegistration();
       dtoPostRegistration.role = allUsers.role;
       dtoPostRegistration.login= allUsers.email;
       dtoPostRegistration.role="AllUsers";



        return dtoPostRegistration;
    }
}
///registration
//        Body:  {name, surname, email, password, repeatpassword, phone, dateofbirth,
//        city – заполнение всех полей обязательно; skype, viber, whatsapp, telegram,
//        vk, facebook, instagram – не обязательно}, role=user}
//        Response: назначить id юзеру – userid, направление на страницу, с которой был запуск регистрации,
//        назначить role – по умолчанию всегда user (на trainer может изменить администратор).
