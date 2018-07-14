package ru.sbt.sn.dto;

public interface ISendable {
    String PART_SEPARATOR = "-#-";

    String toMessage();
}
