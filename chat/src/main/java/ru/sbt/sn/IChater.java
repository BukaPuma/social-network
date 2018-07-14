package ru.sbt.sn;

import ru.sbt.sn.exception.ChatDenyException;

public interface IChater {
    void sendChatMessage( User sender, User receiver, String message ) throws ChatDenyException;
}
