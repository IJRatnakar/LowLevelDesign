package com.lld.loggingsystem;

import lombok.Setter;

public class InfoLoggerLevel implements ILoggerLevel {

    private ILoggerLevel nextLoggerLevel;

    @Setter
    private ISink sink;
    private final LogLevel logLevel;

    InfoLoggerLevel(ISink sink) {
        this.sink = sink;
        logLevel = LogLevel.INFO;
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
