package com.lld.loggingsystem;

import java.util.HashMap;

import lombok.Getter;

public class LoggerConfiguration {
    @Getter
    private static ILogMessageHandler logmsgHandler;
    @Getter
    private static ILogMessagePrinter logMessagePrinter;
    private static HashMap<LogLevel,ILogMessageHandler> logmsgHandlerMap;
    private static HashMap<PrinterType,ILogMessagePrinter> logMessagePrinterMap;

    private LoggerConfiguration() {

    }

    public static void setLogMessageHandler(LogLevel logLevel) {
        logmsgHandler = logmsgHandlerMap.get(logLevel);
    }

    public static void setLogMessagePrinter(PrinterType printerType) {
        logMessagePrinter = logMessagePrinterMap.get(printerType);
    }

    private static void initLogMessagePrinterMap() {
        logMessagePrinterMap = new HashMap<>();
        logMessagePrinterMap.put(PrinterType.CONSOLE, new ConsoleLogMessagePrinter());
        logMessagePrinter = logMessagePrinterMap.get(PrinterType.CONSOLE);
    }

    private static void initLogMessageHandlerMap() {
        logmsgHandlerMap = new HashMap<>();
        logmsgHandlerMap.put(LogLevel.VERBOSE, new VerboseLogMessageHandler(logMessagePrinter));
        logmsgHandlerMap.put(LogLevel.DEBUG, new DebugLogMessageHandler(logMessagePrinter));
        logmsgHandlerMap.put(LogLevel.INFO, new InfoLogMessageHandler(logMessagePrinter));
        logmsgHandlerMap.put(LogLevel.ERROR, new ErrorLogMessageHandler(logMessagePrinter));
        logmsgHandler = logmsgHandlerMap.get(LogLevel.INFO);
    }

    private static void configureNextLoggerhandler() {
        logmsgHandlerMap.get(LogLevel.VERBOSE).setNextLogMessageHandler(logmsgHandlerMap.get(LogLevel.DEBUG));
        logmsgHandlerMap.get(LogLevel.DEBUG).setNextLogMessageHandler(logmsgHandlerMap.get(LogLevel.INFO));
        logmsgHandlerMap.get(LogLevel.INFO).setNextLogMessageHandler(logmsgHandlerMap.get(LogLevel.ERROR));
    }

    public static void initLoggerConfiguration() {
        initLogMessagePrinterMap();
        initLogMessageHandlerMap();
        configureNextLoggerhandler();
    }
}
