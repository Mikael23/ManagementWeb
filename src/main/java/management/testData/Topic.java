package management.testData;

public class Topic {

    String name;

    String discription;

    String swfLinc;

    String imgLinc;

//	List<CourseNameTrainer> coursesNames;


    public Topic(){

    }

    public Topic(String name, String discription, String swfLinc, String imgLinc) {
        this.name = name;
        this.discription = discription;
        this.swfLinc = swfLinc;
        this.imgLinc = imgLinc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getSwfLinc() {
        return swfLinc;
    }

    public void setSwfLinc(String swfLinc) {
        this.swfLinc = swfLinc;
    }

    public String getImgLinc() {
        return imgLinc;
    }

    public void setImgLinc(String imgLinc) {
        this.imgLinc = imgLinc;
    }
}
