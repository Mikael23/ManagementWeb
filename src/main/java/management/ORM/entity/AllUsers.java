package management.ORM.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "User")
@Table(name = "allUsers")
public class AllUsers implements Serializable {

    @OneToOne
    public Schedule schedule;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<Course> getListOfRecords() {
        return listOfRecords;
    }

    public void setListOfRecords(List<Course> listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    @JsonProperty("name")
    public String name;
    @JsonProperty("surname")
    public String surname;
    @Id
    @JsonProperty("email")
    public String email;
    @JsonProperty("password")
    public String password; // Eto nado
    @JsonProperty("repeatPassword")
    public String repeatPassword;
    @JsonProperty("role")
    public String role;


    //    public List<Course> listOfCources;

    @GeneratedValue
    @JsonProperty("Id")
    public Integer id;
    @JsonProperty("NumPhone")
    public String NumPhone;
    @JsonProperty("DateOfBirth")
    public int dateOfBirth;
    @JsonProperty("city")
    public String city;
    @JsonProperty("skype")
    public String skype;
    @JsonProperty("viber")
    public Integer viber;
    @JsonProperty("whats'up")
    public Integer whatsupp;
    @JsonProperty("telegram")
    public String telegramm;
    @JsonProperty("Vk")
    public String VK;
    @JsonProperty("facebook")
    public String facebook;
    @JsonProperty("Instagram")
    public String instagram;


//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "Employee_Project",
//            joinColumns = { @JoinColumn(name = "employee_id") },
//            inverseJoinColumns = { @JoinColumn(name = "project_id") }
//    )

//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "User_Course",joinColumns ={@JoinColumn(name = "user_email")},
//    inverseJoinColumns = {@JoinColumn(name = "course_id")})

    @ManyToMany(mappedBy = "listOfAllUsers")
    @JsonProperty("record")
    public List<Course> listOfRecords;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<Course> getListOfCources() {
//        return listOfCources;
//    }
//
//    public void setListOfCources(List<Course> listOfCources) {
//        this.listOfCources = listOfCources;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumPhone() {
        return NumPhone;
    }

    public void setNumPhone(String numPhone) {
        NumPhone = numPhone;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Integer getViber() {
        return viber;
    }

    public void setViber(Integer viber) {
        this.viber = viber;
    }

    public Integer getWhatsupp() {
        return whatsupp;
    }

    public void setWhatsupp(Integer whatsupp) {
        this.whatsupp = whatsupp;
    }

    public String getTelegramm() {
        return telegramm;
    }

    public void setTelegramm(String telegramm) {
        this.telegramm = telegramm;
    }

    public String getVK() {
        return VK;
    }

    public void setVK(String VK) {
        this.VK = VK;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @JsonCreator
    public AllUsers() {
    }


//
//    POST:
//            /courseid/choose – запись на курс на конкретное время
//    Body: { courseid, userid, date, time, confirmed = false }
//    Response: вернуть ошибку, если пользователь уже записан на это время
//    Если все успешно, данные дата и время попадают в неподтвержденные записи у тренера, и
//    как неподтвержденные – в личный кабинет пользователя, тренеру отправляется оповещение
//    на e-mail о новой записи. Выбранное время перестает быть свободным.
//    В базу данных заносится параметр confirmed = false, который поменяется на true после подтверждения. Значение busy меняется на true.
//    Пока есть косяк с тем, как уменьшать после записи юзера количество (quantity)
//    оставшихся мест для записи на конкретный интервал времени.
//


}
