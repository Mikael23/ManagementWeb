package management.Service.implementations;


import management.DTO.TopicDTO;
import management.DTO.TopicSwfDTO;
import management.ORM.entity.TopicEntity;
import management.services.Interfaces.CourseServiceInt;
import management.services.Interfaces.TopicCRUD;
import management.services.Interfaces.TopicInterfaceOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TopicImplementationOut implements TopicInterfaceOut {

    @Autowired
    TopicCRUD topicCRUD;

    @Autowired
    CourseServiceInt courseServiceInt;

//    @Autowired
//    TimeCRUD timeCRUD;

    @Override
    public String addTopics() {

        return null;
    }

    @Override
    public List<TopicDTO> getAllTopics() {
        List<TopicDTO> topicsRes = new ArrayList<>();
        List<TopicEntity> topicsEntity = topicCRUD.getallTopics();
        for (TopicEntity topic : topicsEntity) {
            topicsRes.add(new TopicDTO(topic));
        }
        return topicsRes;
    }

    @Override
    public List<TopicSwfDTO> getAllTopicsSwf() {
        List<TopicSwfDTO> topicsRes = new ArrayList<>();
        List<TopicEntity> topicsEntity = topicCRUD.getallTopics();
        for (TopicEntity topic : topicsEntity) {
            topicsRes.add(new TopicSwfDTO(topic));
        }
        return topicsRes;
    }

    @Override
    public int addNewTopic(TopicDTO topic) {
        int res = 0;
        TopicEntity topicEntity = new TopicEntity(topic);
        
        if (topicCRUD.addTopic(topicEntity)) {
            res = 1;
        }
        return res;
    }

//    @Override
//    public int addNewTime(TimeDTO time) {
//        int res = 0;
//
//        TimeEntity timeEntity = new TimeEntity(time);
//        if (timeCRUD.addTime(timeEntity)) {
//            res = 1;
//        }
//        return res;
//    }
//
//    @Override
//    public List<TimeDTO> getCourseSchedul() {
//        List<TimeDTO> timeRes = new ArrayList<>();
//        List<TimeEntity> timeEntity = timeCRUD.getSchedule();
//        for (TimeEntity time : timeEntity) {
//            timeRes.add(new TimeDTO(time));
//        }
//        return timeRes;
//    }
//
//    @Override
//    public List<TimeDTO> getFreeSchedul() {
//        List<TimeDTO> timeRes = new ArrayList<>();
//        List<TimeEntity> timeEntity = timeCRUD.getFreeTime();
//        for (TimeEntity time : timeEntity) {
//            timeRes.add(new TimeDTO(time));
//        }
//        return timeRes;
//    }


}
