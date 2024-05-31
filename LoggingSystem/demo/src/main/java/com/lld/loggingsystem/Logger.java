package com.lld.loggingsystem;

public class Logger {
    private ILogMessageHandler logmsgHandler;
    private static Logger loggerSingleton;
    private Logger() {
        logmsgHandler = LoggerConfiguration.getLogmsgHandler();
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
        logmsgHandler.logMessage(message);
    }
}
