package com.lld.loggingsystem;

public class Main {
    public static void main(String[] args) {
        LoggerConfiguration.initLoggerConfiguration();
        LoggerConfiguration.setLogMessageHandler(LogLevel.DEBUG);
        LoggerConfiguration.setLogMessagePrinter(PrinterType.CONSOLE);
        Logger logger = Logger.getInstance();
        logger.logMessage(new Message("Successfully generated token", "com.ij.token", LogLevel.ERROR));
        logger.logMessage(new Message("Successfully generated token", "com.ij.token", LogLevel.INFO));
        logger.logMessage(new Message("Successfully generated token", "com.ij.token", LogLevel.VERBOSE));
        logger.logMessage(new Message("Successfully generated token", "com.ij.token", LogLevel.DEBUG));
        logger.logMessage(new Message("Successfully generated token", "com.ij.token", LogLevel.ERROR));
    }
}