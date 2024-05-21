package com.lld.loggingsystem;

public interface ILoggerLevel {
    public void logMessage(Message message);
    public void setNextLogger(ILoggerLevel loggerLevel);
    public void handleNextLogger(Message message);
}
