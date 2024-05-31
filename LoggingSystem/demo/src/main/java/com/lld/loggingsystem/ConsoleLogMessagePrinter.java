package com.lld.loggingsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogMessagePrinter implements ILogMessagePrinter {

    @Override
    public void printMessage(Message message) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println(formattedDate + "  " + message.getClientPkg() + "   "+ message.getLogLevel() + "  " + message.getMsg());
    }
    
}
