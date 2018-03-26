package management.ORM.entity;


import management.DTO.TopicDTO;
import management.services.Interfaces.CourseServiceInt;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Topics")
public class TopicEntity {
 //23
    @Autowired
    CourseServiceInt courseInterfase;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CodInner")
    private int codInner; // primary key?

    @Id
    private String name;
    private String description;
    private String lincImg;
    private String lincSwf;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Course> courses;

    public TopicEntity() {

    }

    public TopicEntity(int codInner, String name, String description, String lincImg, String lincSwf, List<Course> courses) {
        this.codInner = codInner;
        this.name = name;
        this.description = description;
        this.lincImg = lincImg;
        this.lincSwf = lincSwf;
        this.courses = courses;
    }

    public TopicEntity(TopicDTO topicDTO){

        name = topicDTO.getName();
        lincImg = topicDTO.getImgLinc();
        lincSwf = topicDTO.getSwfLinc();
        courses = courseInterfase.getCoursesByName(topicDTO.getNamesOfCourses());
    }

    public int getCodInner() {
        return codInner;
    }

//    public void setCodInner(int codInner) {
//        this.codInner = codInner;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLincImg() {
        return lincImg;
    }

    public void setLincImg(String lincImg) {
        this.lincImg = lincImg;
    }

    public String getLincSwf() {
        return lincSwf;
    }

    public void setLincSwf(String lincSwf) {
        this.lincSwf = lincSwf;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "TopicEntity{" +
                "codInner=" + codInner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", lincImg='" + lincImg + '\'' +
                ", lincSwf='" + lincSwf + '\'' +
                '}';
    }
}
