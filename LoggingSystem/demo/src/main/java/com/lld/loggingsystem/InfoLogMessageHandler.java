package com.lld.loggingsystem;

import lombok.Setter;

public class InfoLogMessageHandler implements ILogMessageHandler {

    private ILogMessageHandler nextLogHandler;
    @Setter
    private ILogMessagePrinter logMessagePrinter;
    private final LogLevel logLevel;

    InfoLogMessageHandler(ILogMessagePrinter logMessagePrinter) {
        this.logMessagePrinter = logMessagePrinter;
        logLevel = LogLevel.INFO;
    }

    @Override
    public void logMessage(Message message) {
        if(message.getLogLevel() == logLevel) {
            logMessagePrinter.printMessage(message);
        } else {
            handleNextLogMessageHandler(message);
        }
    }

    @Override
    public void setNextLogMessageHandler(ILogMessageHandler logMessageHandler) {
        nextLogHandler = logMessageHandler;
    }

    @Override
    public void handleNextLogMessageHandler(Message message) {
        if(nextLogHandler != null) {
            nextLogHandler.logMessage(message);
        }
    }
}