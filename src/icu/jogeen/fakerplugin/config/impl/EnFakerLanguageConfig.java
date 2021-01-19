package icu.jogeen.fakerplugin.config.impl;

import com.github.javafaker.Faker;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @Author jogeen
 * @Date 17:40 2021/1/19
 * @Version v1.0
 * @Description
 */
public class EnFakerLanguageConfig extends BaseFakerLanguageConfig {

    private Faker faker;

    public EnFakerLanguageConfig(Locale locale) {
        faker = new Faker(locale);

    }

    @Override
    public List<Topic> getTopics() {
        List<Topic> list = new ArrayList<>();
        list.add(new Topic("动物","animal"));
        list.add(new Topic("城市","city"));
        return  list;
    }

    @Override
    public List<Field> getFields(Topic topic) {
        List<Field> list = new ArrayList<>();
        list.add(new Field("名称","name"));
        list.add(new Field("数量","num"));
        return  list;
    }
}
