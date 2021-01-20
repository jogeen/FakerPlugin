package icu.jogeen.fakerplugin.config;

import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.List;
import java.util.Map;

/**
 * @Author jogeen
 * @Date 10:57 2021/1/20
 * @Version v1.0
 * @Description
 */
public interface LanguageConfig {

    public List<Topic> getTopics();

    public Map<Topic, List<Field>> getTopicMap();

}
