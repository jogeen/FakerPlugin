package icu.jogeen.fakerplugin.config;

import com.github.javafaker.Faker;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.List;

/**
 * @Author jogeen
 * @Date 15:57 2021/1/19
 * @Version v1.0
 * @Description
 */
public interface FakerLanguageConfig {
    public List<Topic> getTopics();

    public List<Field> getFields(Topic topic);

    public String invoke(Topic topic, Field field);

    public Topic getTopic(String name);

    public Field getFields(String name);

}
