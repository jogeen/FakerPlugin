package icu.jogeen.fakerplugin.config.impl;

import icu.jogeen.fakerplugin.config.FakerLanguageConfig;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.List;

/**
 * @Author jogeen
 * @Date 17:40 2021/1/19
 * @Version v1.0
 * @Description
 */
public class BaseFakerLanguageConfig implements FakerLanguageConfig {

    @Override
    public List<Topic> getTopics() {
        return null;
    }

    @Override
    public List<Field> getFields(Topic topic) {
        return null;
    }

    @Override
    public String invoke(Topic topic, Field field) {
        return null;
    }

    @Override
    public Topic getTopic(String name) {
        return null;
    }

    @Override
    public Field getFields(String name) {
        return null;
    }
}
