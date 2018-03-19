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
import java.util.ArrayList;
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
    public boolean login(AllUsers allUsers) {
        return false;
    }

    @Override
    public List<String> allUserId() {
//        String jpql = "SELECT r FROM Course r where confirmed=true";


        String jpql = "SELECT r FROM User r";

        List<AllUsers> users = em.createQuery(jpql, AllUsers.class).getResultList();
        List<String> usersId = new ArrayList<>();

        for (AllUsers user : users) {
            usersId.add(user.email);
        }

        return usersId;


    }



    @Override
    public DtoGettingThisDateN gettingDateOfUser(Integer id) {
        return null;
    }

    @Override
    public DTOlogging logging(AllUsers allUsers) throws Exception {

        AllUsers allUsers1 = em.find(AllUsers.class, allUsers.email);
        if (allUsers1 == null) {
            throw new Exception("please logg in");
        }

        String password = allUsers1.password;
        String EnteredPassword = allUsers.password;
        if (!password.equals(EnteredPassword)) {
            throw new Exception("incorrect password");
        }

        DTOlogging dtOlogging = new DTOlogging();
        dtOlogging.role = allUsers1.role;
        dtOlogging.name = allUsers1.name;
        dtOlogging.surname = allUsers1.surname;

        return dtOlogging;

    }

    @Transactional
    @Override
    public DtoUpdatingProfile update(AllUsers user) throws Exception {
        String email = user.email;
        DtoUpdatingProfile dtoUpdatingProfile = new DtoUpdatingProfile();

        AllUsers allUsers1 = em.find(AllUsers.class, email);
        if (allUsers1 == null) {
            throw new Exception("Please log in");

        }


        AllUsers user2 = allUsers1;
        em.remove(allUsers1);

        if (user.email != null) {
            user2.email = user.email;
        }


        if (user.name != null) {
            user2.name = user.name;
        }
        if (user.surname != null) {
            user2.surname = user.surname;
        }
        if (user.password != null) {
            user2.password = user.password;
            if (!user.repeatPassword.equals(user.password)) {
                throw new Exception("Enter repeat of password");
            }
        }
        if (user.NumPhone != null) {
            user2.NumPhone = user.NumPhone;
        }
        if (user.city != null) {
            user2.city = user.city;
        }
        if (user.skype != null) {
            user2.skype = user.skype;
        }
        if (user.viber != null) {
            user2.skype = user.skype;
        }
        if (user.whatsupp != null) {
            user2.whatsupp = user.whatsupp;
        }
        if (user.telegramm != null) {
            user2.telegramm = user.telegramm;
        }
        if (user.VK != null) {
            user2.VK = user.VK;
        }
        if (user.facebook != null) {
            user2.facebook = user.facebook;
        }
        if (user.instagram != null) {
            user2.instagram = user.instagram;
        }

        em.persist(user2);
        dtoUpdatingProfile.email = user2.email;
        dtoUpdatingProfile.name = user2.name;
        dtoUpdatingProfile.surname = user2.surname;
        dtoUpdatingProfile.numberOfMistake = 200;
        return dtoUpdatingProfile;


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


        AllUsers allUsers1 = em.find(AllUsers.class, allUsers.email);
        if (allUsers1 != null) {
            throw new Exception("We have got this allUsers already");
        }
        System.out.println(allUsers.id);
        String pas = allUsers.password;
        String repeatOfPas = allUsers.repeatPassword;
        if (!pas.equals(repeatOfPas)) {
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
            if (count < 2) {
                throw new Exception("No enough of numbers");
            }
        }


        em.persist(allUsers);
        DtoPostRegistration dtoPostRegistration = new DtoPostRegistration();
        dtoPostRegistration.role = allUsers.role;
        dtoPostRegistration.login = allUsers.email;
        dtoPostRegistration.role = "User";


        return dtoPostRegistration;
    }
}
///registration
//        Body:  {name, surname, email, password, repeatpassword, phone, dateofbirth,
//        city – заполнение всех полей обязательно; skype, viber, whatsapp, telegram,
//        vk, facebook, instagram – не обязательно}, role=user}
//        Response: назначить id юзеру – userid, направление на страницу, с которой был запуск регистрации,
//        назначить role – по умолчанию всегда user (на trainer может изменить администратор).
