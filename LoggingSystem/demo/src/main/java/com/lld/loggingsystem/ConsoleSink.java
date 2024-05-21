package com.lld.loggingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleSink implements ISink {

    @Override
    public void logMessageToSink(Message message) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(formattedDate + "  " + message.getClientPkg() + "   "+ message.getLogLevel() + "  " + message.getMsg());
    }
    
}
