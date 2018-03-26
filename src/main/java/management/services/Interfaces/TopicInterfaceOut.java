package management.services.Interfaces;




import management.DTO.TopicDTO;
import management.DTO.TopicSwfDTO;

import java.util.List;


public interface TopicInterfaceOut {

    String addTopics();
    List<TopicDTO> getAllTopics();
    List<TopicSwfDTO> getAllTopicsSwf();
    int addNewTopic(TopicDTO topic);
//    int addNewTime(TimeDTO time);
//    List<TimeDTO> getCourseSchedul();
//    List<TimeDTO> getFreeSchedul();
}
