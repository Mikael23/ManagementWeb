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

///courseid/datestimes - получаем незанятые даты и время у конкретного тренера с
//    конкретной длительностью сеанса курса по нажатию "Записаться на курс" по courseid из intervals.
//    Параметр "duration" должен быть получен из courseid (то есть каждый course должен знать свой duration) +
//    добавляться 30 минут на перерыв. То есть, если "duration" - 1 час 30 минут, то, чтобы была
//    возможность записаться на курс, промежуток найденного времени (intervalid) должен составлять 2 часа.
//    Диапазон дат для записей - месяц. Если пользователь не залогинен, - переадресация на логин/регистрацию
//    и после нее получение возможных дат и времени. Когда пользователь залогинен, будет ли добавляться ко
//    всем ссылкам-действиям вначале /userid , где оно важно? Важно привязать конкретные курсы к конкретным тренерам.
//    Чтобы курсы с id (к примеру) 1,2,3 попадали в расписание тренера trainerid. Ведущими одного курса могут быть два тренера,
//    тогда при записи на курс к одному тренеру будет courseid отличное, от courseid при записи на этот же курс к другому тренеру.
//            Response:
//    Если свободные дата и время найдены, то возвращает suggesteddate и suggestedtime. Дальше выбор времени, даты, курса,
//    добавление сообщения по желанию, переход к шагу /courseid/choose.
//    Если свободные дата и время не найдены, добавить userid и courseid в список ожидания (/waitinglist)
//    администратора и выдать сообщение о том, что, к сожалению, на данный курс пока нет свободного времени,
//    но ваше имя добавлено в список ожидающих, и вы будете оповещены, когда появится время для записи.
}
