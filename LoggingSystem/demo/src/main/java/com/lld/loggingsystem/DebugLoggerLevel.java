package com.lld.loggingsystem;

import lombok.Setter;

public class DebugLoggerLevel implements ILoggerLevel {

    private ILoggerLevel nextLoggerLevel;
    @Setter
    private ISink sink;
    private final LogLevel logLevel;

    DebugLoggerLevel(ISink sink) {
        this.sink = sink;
        logLevel = LogLevel.DEBUG;
    }

    @Override
    public void logMessage(Message message) {
        if(message.getLogLevel() == logLevel) {
            sink.logMessageToSink(message);
        } else {
            handleNextLogger(message);
        }
    }

    @Override
    public void setNextLogger(ILoggerLevel loggerLevel) {
        nextLoggerLevel = loggerLevel;
    }

    @Override
    public void handleNextLogger(Message message) {
        if(nextLoggerLevel != null) {
            nextLoggerLevel.logMessage(message);
        }
    }
    
}
