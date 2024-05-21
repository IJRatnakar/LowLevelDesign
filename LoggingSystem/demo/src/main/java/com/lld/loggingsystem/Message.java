package com.lld.loggingsystem;

import lombok.Getter;

public class Message {
    @Getter
    private final String msg;
    @Getter
    private final String clientPkg;
    @Getter
    private final LogLevel logLevel;

    Message(String msg, String clientPkg, LogLevel logLevel) {
        this.msg = msg;
        this.clientPkg = clientPkg;
        this.logLevel = logLevel;
    }
}
