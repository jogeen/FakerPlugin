package icu.jogeen.fakerplugin.config;

import com.github.javafaker.Faker;
import icu.jogeen.fakerplugin.config.impl.EnFakerLanguageConfig;
import icu.jogeen.fakerplugin.config.impl.ZhFakerLanguageConfig;

import java.util.Locale;

/**
 * @Author jogeen
 * @Date 15:57 2021/1/19
 * @Version v1.0
 * @DescriptionLo
 */
public class FakerLanguageConfigFactory {
    public static FakerLanguageConfig createFakerLanguageConfig() {
        return new EnFakerLanguageConfig(Locale.ENGLISH);
    }
}
