package ru.sbt.sn;

import ru.sbt.sn.dto.ISendable;

public interface ISender {
    void send( ISendable sendable );
}
