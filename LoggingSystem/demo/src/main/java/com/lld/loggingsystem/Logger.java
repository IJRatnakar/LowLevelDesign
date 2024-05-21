package com.lld.loggingsystem;

public class Logger {
    private ILoggerLevel loggerLevel;
    private static Logger loggerSingleton;
    private Logger() {
        loggerLevel = LoggerConfiguration.getLoggerLevel();
    }

    public static Logger getInstance() {
        if(loggerSingleton == null) {
            synchronized(Logger.class) {
                if(loggerSingleton == null) {
                    loggerSingleton = new Logger();
                }
            }
        }
        return loggerSingleton;
    }

    public void logMessage(Message message) {
        loggerLevel.logMessage(message);
    }
}
