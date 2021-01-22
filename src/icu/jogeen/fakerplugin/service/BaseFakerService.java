package icu.jogeen.fakerplugin.service;

import com.github.javafaker.Faker;
import icu.jogeen.fakerplugin.config.LanguageConfig;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @Author jogeen
 * @Date 11:30 2021/1/20
 * @Version v1.0
 * @Description
 */
public class BaseFakerService implements FakerService {

    private Faker faker;
    private List<Topic> topics;
    private Map<String, List<Field>> map;
    private LanguageConfig languageConfig;

    private static Map<Locale, LanguageConfig> configMap;


    public BaseFakerService(Locale locale) {
        this.faker = new Faker(locale);

    }

    @Override
    public List<String> getTopics() {
        return Arrays.asList("city","color","address");
    }

    @Override
    public List<String> getFields(int index) {
        if(index==0){
            return Arrays.asList("name1","hehe3");
        }
        if(index==1){
            return Arrays.asList("name2","hehe3");
        }

            return Arrays.asList("name3","hehe3");


    }

    @Override
    public String invoke(int topic, int field) {
        return faker.address().cityName();
    }
}
