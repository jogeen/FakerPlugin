package icu.jogeen.fakerplugin.config.model;

/**
 * @Author jogeen
 * @Date 17:31 2021/1/19
 * @Version v1.0
 * @Description
 */
public class Topic {
    private String name;
    private String value;

    public Topic(){}

    public Topic(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Topic setValue(String value) {
        this.value = value;
        return this;
    }
}
