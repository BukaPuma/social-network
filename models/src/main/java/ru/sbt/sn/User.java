package ru.sbt.sn;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String id;
    private String name;
    private int age;

    //ui settings
    private Object font;
    private Object background;
}
