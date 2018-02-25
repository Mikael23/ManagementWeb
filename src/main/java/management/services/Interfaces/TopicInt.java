package management.services.Interfaces;

import management.DTO.TopicDTO;
import management.DTO.TopicSwfDTO;

import java.util.List;

public interface TopicInt {
    String addTopics();
    List<TopicDTO> getAllTopics();
    List<TopicSwfDTO> getAllTopicsSwf();
    int addNewTopic(TopicDTO topic);
}
