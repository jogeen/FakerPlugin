package icu.jogeen.fakerplugin.config.model;

/**
 * @Author jogeen
 * @Date 17:32 2021/1/19
 * @Version v1.0
 * @Description
 */
public class Field {
    private String name;
    private String value;

    public Field(){}

    public Field(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Field setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Field setValue(String value) {
        this.value = value;
        return this;
    }
}
