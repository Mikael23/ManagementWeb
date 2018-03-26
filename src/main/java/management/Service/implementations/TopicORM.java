package management.Service.implementations;

import management.ORM.entity.TopicEntity;

import management.services.Interfaces.TopicCRUD;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TopicORM implements TopicCRUD {
    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional
    public boolean addTopic(TopicEntity topic) {
        boolean result = false;
        if (em.find(TopicEntity.class, topic.getName()) == null) {
            em.persist(topic);
            result = true;
        }
        return result;
    }

    @Override
    public List<TopicEntity> getallTopics() {
        List<TopicEntity> result = em.createQuery(
                "select t from TopicEntity t", TopicEntity.class).getResultList();
        return result;
    }




}
