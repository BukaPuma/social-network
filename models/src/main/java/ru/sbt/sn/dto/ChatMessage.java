package ru.sbt.sn.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChatMessage extends AbstractMessage {
    private Object font;        //TODO in real project it should be concrete type like FontSettings
    private Object background;  //TODO in real project it should be concrete type like BackgroundSettings

    @Override
    public String toMessage() {
        return super.toMessage() + PART_SEPARATOR + font + PART_SEPARATOR + background;
    }
}
