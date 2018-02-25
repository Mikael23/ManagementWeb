package management.Service.implementations;

import management.DTO.Course;
import management.DTO.Trainer;
import management.DTO.User;
import management.services.Interfaces.AddingCourseInt;
import management.services.Interfaces.CourseService;
import management.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class UserServiceImplemen implements UserService {


    private Map<Integer, User> users = new HashMap<Integer, User>();
    private final AtomicInteger idCounter = new AtomicInteger();


    @Autowired
    AddingCourseInt addingCourseInt;

    @Autowired
    CourseService courseService;


    public int save(User user) {

        int id = idCounter.getAndIncrement();
        user.id = id;
        users.put(id, user);


        return id;
    }

    public boolean login(User user) {
        //String role = user.role;

        String email = user.email;
        String password = user.password;

        for (User em : users.values()) {
            if (em.email.equals(email)) {
                int id = em.id;
                User paw = users.get(id);

                String pas = paw.password;
                //    System.out.println(pas + );
                if (pas.equals(password)) {
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

        users.put(user1, user);

        return user;

    }

    @Override
    public List<Course> choosingTime(String name, Course course) throws Exception {


        double[] suggestedTimes = new double[2];
        Trainer trainer = new Trainer();
        Course course1 = addingCourseInt.li().get(course.name);
        course1.ChoosenData = course.ChoosenData;
        course1.ChoosenTime = course.ChoosenTime;
        course1.name = course.name;
//        course1.SuggestedTimes = course.SuggestedTimes;
//        course1.SuggestedData = course.SuggestedData;
        Double time = course1.ChoosenTime;
        Double data = course1.ChoosenData;

        Integer id = 0;

        for (User user1 : users.values()) {
            if (user1.name.equals(name)) {
                id = user1.id;
            }
        }
        User user1 = users.get(id);

        double[] times = course1.SuggestedTimes;
        double[] dates = course1.SuggestedData;


        System.out.println(course1.name);
        for (int i = 0; i <= times.length - 1; i++) {
            System.out.println(times[i]);
            System.out.println(course1.ChoosenTime);
            if (times[i] == course1.ChoosenTime) {
                System.out.println("V pervii zashli");
                for (int r = 0; r <= dates.length - 1; r++) {
                    System.out.println(dates[r]);
                    if (dates[r] == course1.ChoosenData) {

                        List<Course> courcesOfUsers = new ArrayList<>();
                        courcesOfUsers.add(course1);
                        user1.courcesOfUsers.put(user1.name, courcesOfUsers);
                        List<Course> er = user1.courcesOfUsers.get(name);
                        times[i] = 0;
                        dates[r] = 0;

                        addingCourseInt.li().remove(course1.name);
                        course1.SuggestedTimes = times;
                        course1.SuggestedData = dates;
                        addingCourseInt.addCourse(course1);

                        return er;
                    }
                }
            }

        }
        throw new Exception(new NoSuchElementException());


//        System.out.println("user" + user1);
//        System.out.println("her");
//        System.out.println("kurs" + course1);


    }


}