package org.example.cs2016.q2;

public class Main {
    public static void main(String[] args) {
//        LogMessage message1 = new LogMessage("Server1:file not found");
//        System.out.println(message1.getMachineId());
//        System.out.println(message1.getDescription());
//
//        message1 = new LogMessage("Server4:disk1 disk not found");
//        System.out.println(message1.getMachineId());
//        System.out.println(message1.getDescription());
//
//        System.out.println(message1.containsWord("disk"));

        SystemLog systemLog = new SystemLog();
        systemLog.printMessage();

        System.out.println("");
        systemLog.removeMessages("disk");
        systemLog.printMessage();
    }
}