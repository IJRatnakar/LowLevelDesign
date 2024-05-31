package com.lld.loggingsystem;

public interface ILogMessageHandler {
    public void logMessage(Message message);
    public void setNextLogMessageHandler(ILogMessageHandler loggerLevel);
    public void handleNextLogMessageHandler(Message message);
}
