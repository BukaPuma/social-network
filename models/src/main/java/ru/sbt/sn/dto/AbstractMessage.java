package ru.sbt.sn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractMessage implements ISendable {
    private String text;
    private Boolean status;
    private String errorText;

    public String toMessage() {
        return text;
    }
}
