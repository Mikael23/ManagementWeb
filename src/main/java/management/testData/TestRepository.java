package management.testData;

import java.util.ArrayList;
import java.util.List;

public class TestRepository {
   private static List<Topic> topicsStore = new ArrayList<>();
    Topic newTopic;
    public TestRepository() {

    }

    public static List<Topic> getTopicsStore() {
        return topicsStore;
    }

    public static void setTopicsStore(List<Topic> topicsStore) {
        TestRepository.topicsStore = topicsStore;
    }

    public static String addT(Topic topic){
        String res = "Created";
        topicsStore.add(topic);
        return res;
    }
}
