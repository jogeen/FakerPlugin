package icu.jogeen.fakerplugin.config.enums;

import icu.jogeen.fakerplugin.config.LanguageConfig;
import icu.jogeen.fakerplugin.config.impl.DefaultLanguageConfig;

/**
 * @Author jogeen
 * @Date 11:41 2021/1/20
 * @Version v1.0
 * @Description
 */
public enum LanguageConfigEnum {
    ZH(new DefaultLanguageConfig());

    private LanguageConfig config;

    LanguageConfigEnum(LanguageConfig config) {
        this.config = config;
    }
}
