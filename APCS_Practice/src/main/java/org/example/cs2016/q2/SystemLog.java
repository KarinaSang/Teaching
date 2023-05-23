package org.example.cs2016.q2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SystemLog {
    private List<LogMessage> messageList;

    public SystemLog() {
        messageList = new ArrayList<>();

        messageList.add(new LogMessage("Server1:disk1 not found"));
        messageList.add(new LogMessage("Server4:disk1 disk not found"));
        messageList.add(new LogMessage("Server2:disk1 not found"));
    }

    public List<LogMessage> removeMessages(String keyword) {
        List<LogMessage> result = new ArrayList<>();

        for (int i = 0; i < messageList.size(); i++) {
            LogMessage message = messageList.get(i);

            if (message.containsWord(keyword)) {
                result.add(messageList.remove(i));
            }

        }

        return result;
    }

    public void printMessage() {
        for (LogMessage message: messageList) {
            System.out.println(message.getMachineId());
            System.out.println(message.getDescription());
        }
    }
}
