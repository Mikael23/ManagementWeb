package management.Service.implementations;


import management.DTO.TopicDTO;
import management.DTO.TopicSwfDTO;
import management.services.Interfaces.TopicInt;
import management.testData.TestRepository;
import management.testData.Topic;

import java.util.List;

public class TopicImpl implements TopicInt{

    @Override
    public String addTopics() {

        return null;
    }

    @Override
    public List<TopicDTO> getAllTopics() {

        return null;
    }

    @Override
    public List<TopicSwfDTO> getAllTopicsSwf() {
        return null;
    }

    @Override
    public int addNewTopic(TopicDTO topicDto) {
        Topic topic = new Topic();
        topic.setName(topicDto.getName());
        topic.setDiscription(topicDto.getDiscription());
        topic.setImgLinc(topicDto.getImgLinc());
        topic.setSwfLinc(topicDto.getSwfLinc());
        String res = TestRepository.addT(topic);
        return 0;
    }
}
