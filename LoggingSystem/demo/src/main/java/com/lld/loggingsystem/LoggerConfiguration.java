package com.lld.loggingsystem;

import java.util.HashMap;

import lombok.Getter;

public class LoggerConfiguration {
    @Getter
    private static ILoggerLevel loggerLevel;
    @Getter
    private static ISink sink;
    private static HashMap<LogLevel,ILoggerLevel> loggerLevelMap;
    private static HashMap<SinkType,ISink> sinkMap;

    private LoggerConfiguration() {

    }

    public static void setLoggerLevel(LogLevel logLevel) {
        loggerLevel = loggerLevelMap.get(logLevel);
    }

    public static void setSink(SinkType sinkType) {
        sink = sinkMap.get(sinkType);
    }

    private static void initSinkMap() {
        sinkMap = new HashMap<>();
        sinkMap.put(SinkType.CONSOLE, new ConsoleSink());
        sink = sinkMap.get(SinkType.CONSOLE);
    }

    private static void initLoggerLevelMap() {
        loggerLevelMap = new HashMap<>();
        loggerLevelMap.put(LogLevel.VERBOSE, new VerboseLoggerLevel(sink));
        loggerLevelMap.put(LogLevel.DEBUG, new DebugLoggerLevel(sink));
        loggerLevelMap.put(LogLevel.INFO, new InfoLoggerLevel(sink));
        loggerLevelMap.put(LogLevel.ERROR, new ErrorLoggerLevel(sink));
        loggerLevel = loggerLevelMap.get(LogLevel.INFO);
    }

    private static void configureNextLoggerhandler() {
        loggerLevelMap.get(LogLevel.VERBOSE).setNextLogger(loggerLevelMap.get(LogLevel.DEBUG));
        loggerLevelMap.get(LogLevel.DEBUG).setNextLogger(loggerLevelMap.get(LogLevel.INFO));
        loggerLevelMap.get(LogLevel.INFO).setNextLogger(loggerLevelMap.get(LogLevel.ERROR));
    }

    public static void initLoggerConfiguration() {
        initSinkMap();
        initLoggerLevelMap();
        configureNextLoggerhandler();
    }
}
