package com.lld.loggingsystem;

import lombok.Setter;

public class DebugLogMessageHandler implements ILogMessageHandler {

    private ILogMessageHandler nextLogHandler;
    @Setter
    private ILogMessagePrinter logMessagePrinter;
    private final LogLevel logLevel;

    DebugLogMessageHandler(ILogMessagePrinter logMessagePrinter) {
        this.logMessagePrinter = logMessagePrinter;
        logLevel = LogLevel.DEBUG;
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
