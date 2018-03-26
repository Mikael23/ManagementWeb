package management.ORM.entity;


import management.DTO.TopicDTO;


import javax.persistence.*;

@Entity
@Table(name = "Topics")
public class TopicEntity {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CodInner")
    private int codInner; // primary key?

    @Id
    private String name;
    private String description;
    private String lincImg;
    private String lincSwf;

    public TopicEntity() {

    }

    public TopicEntity(String name, String description, String lincImg, String lincSwf) {

        this.name = name;
        this.description = description;
        this.lincImg = lincImg;
        this.lincSwf = lincSwf;
    }

    public TopicEntity(TopicDTO topicDTO){
        name = topicDTO.getName();
        description = topicDTO.getDiscription();
        lincImg = topicDTO.getImgLinc();
        lincSwf = topicDTO.getSwfLinc();
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
