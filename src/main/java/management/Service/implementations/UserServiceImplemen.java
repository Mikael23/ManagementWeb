package management.Service.implementations;

import management.DTO.Course;
import management.DTO.User;
import management.services.Interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class UserServiceImplemen implements UserService {


    private Map<Integer,User> users = new HashMap<Integer, User>();
    private final AtomicInteger idCounter = new AtomicInteger();






    public int save(User user) {

        int id = idCounter.getAndIncrement();
        user.id=id;
        users.put(id,user);


        return id;
    }

    public boolean login(User user) {
        //String role = user.role;

        String email = user.email;
        String password = user.password;

        for(User em:users.values()){
              if(em.email.equals(email)){
                  int id = em.id;
                  User paw = users.get(id);

                  String pas = paw.password;
              //    System.out.println(pas + );
                  if(pas.equals(password)){
                      System.out.println("voshel");
                      return true;
                  }

              }

        }





        return false;
    }

    @Override
    public User update(User user) {


        Integer user1 = user.id;
        users.remove(user1);

        users.put(user1,user);

        return user;

    }

    @Override
    public List<Course> choosingTime(String name, Course course) {


       double [] suggestedTimes = new double[2] ;



       Course course1 = new Course();
       course1.name = course.name;
       course1.choosenTime = course.choosenTime;


     User user1 =  users.get(name);
     List<Course> courcesOfUsers = new ArrayList<>();
     courcesOfUsers.add(course);

     user1.courcesOfUsers.put(name,courcesOfUsers);

     List<Course>er = user1.courcesOfUsers.get(name);




       return er;


    }

///trainerid/update – обновляет информацию профиля пользователя
//    Body: {name, surname, old password, new password, repeat new password,
//            phone, city, skype, viber, whatsapp, telegram, vk, facebook, instagram }

}
