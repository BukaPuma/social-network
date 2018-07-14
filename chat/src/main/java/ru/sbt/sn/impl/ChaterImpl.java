package ru.sbt.sn.impl;

import ru.sbt.sn.IChater;
import ru.sbt.sn.ISender;
import ru.sbt.sn.User;
import ru.sbt.sn.dto.ChatMessage;
import ru.sbt.sn.exception.ChatDenyException;

import java.util.Objects;

public class ChaterImpl implements IChater {
    private final ISender senderService;

    public ChaterImpl( ISender senderService ) {
        this.senderService = senderService;
    }

    public void sendChatMessage( User sender, User receiver, String message ) throws ChatDenyException {
        if ( !canChat( sender, receiver ) )
            throw new ChatDenyException( "Чат между " + sender.getName() + " и " + receiver.getName() + "запрещен!" );

        ChatMessage chatMessage = ChatMessage.builder()
                .font( receiver.getFont() )
                .font( sender.getBackground() )
                .build();
        chatMessage.setText( message );

        senderService.send( chatMessage );
    }

    // fake checking
    private boolean canChat( User sender, User receiver ) {
        return !Objects.equals( sender, receiver );
    }
}
