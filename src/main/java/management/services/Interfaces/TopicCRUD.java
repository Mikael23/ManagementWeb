package management.services.Interfaces;



import management.ORM.entity.TopicEntity;

import java.util.List;

public interface TopicCRUD {

    boolean addTopic(TopicEntity topic);

    List<TopicEntity> getallTopics();


}
