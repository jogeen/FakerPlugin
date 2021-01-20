package icu.jogeen.fakerplugin.service;

import com.github.javafaker.Faker;
import icu.jogeen.fakerplugin.config.LanguageConfig;
import icu.jogeen.fakerplugin.config.enums.LanguageConfigEnum;
import icu.jogeen.fakerplugin.config.model.Field;
import icu.jogeen.fakerplugin.config.model.Topic;
import icu.jogeen.fakerplugin.service.FakerService;

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
        return null;
    }

    @Override
    public List<String> getFields(int index) {
        return null;
    }

    @Override
    public String invoke(int topic, int field) {
        return null;
    }
}
