package icu.jogeen.fakerplugin.config.impl;

import icu.jogeen.fakerplugin.config.LanguageConfig;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.List;
import java.util.Map;

/**
 * @Author jogeen
 * @Date 17:29 2021/1/20
 * @Version v1.0
 * @Description
 */
public class DefaultLanguageConfig implements LanguageConfig {
    @Override
    public List<Topic> getTopics() {
        return null;
    }

    @Override
    public Map<Topic, List<Field>> getTopicMap() {
        return null;
    }
}
