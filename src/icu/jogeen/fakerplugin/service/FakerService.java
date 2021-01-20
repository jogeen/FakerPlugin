package icu.jogeen.fakerplugin.service;

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
public interface FakerService {
    public List<String> getTopics();

    public List<String> getFields(int index);

    public String invoke(int topic, int field);

}
