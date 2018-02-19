package management.Service;

import management.entity.LoginUser;
import management.entity.ProposeCourse;
import management.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    public boolean login(LoginUser user) {
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


}
