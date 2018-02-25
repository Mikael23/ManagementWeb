package management.Service.implementations;


import management.DTO.TopicDTO;
import management.DTO.TopicSwfDTO;
import management.services.Interfaces.TopicInt;
import management.testData.TestRepository;
import management.testData.Topic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TopicImpl implements TopicInt{

    @Override
    public String addTopics() {

        return null;
    }

    @Override
    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = TestRepository.getTopicsStore();
        List<TopicDTO> topicsDTO = new ArrayList<>();
        for (Topic topic: topics) {
               topicsDTO.add(TopicDTO.refactorTopic(topic));
        }


        return topicsDTO;
    }

    @Override
    public List<TopicSwfDTO> getAllTopicsSwf() {
        List<Topic> topics = TestRepository.getTopicsStore();
        List<TopicSwfDTO> topicsSwfDTO = new ArrayList<>();
        for (Topic topic: topics) {
            topicsSwfDTO.add(TopicSwfDTO.refactorTopic(topic));
        }

        return topicsSwfDTO;
    }

    @Override
    public int addNewTopic(TopicDTO topicDto) {
        Topic topic = new Topic();
        System.out.println(topicDto.getName());
        topic.setName(topicDto.getName());
        topic.setDiscription(topicDto.getDiscription());
        topic.setImgLinc(topicDto.getImgLinc());
        topic.setSwfLinc(topicDto.getSwfLinc());
        String res = TestRepository.addT(topic);

        System.out.println(topic);
        System.out.println(TestRepository.getTopicsStore());
        return 0;
    }
}
