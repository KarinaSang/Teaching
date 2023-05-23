package org.example.cs2016.q2;

public class LogMessage {
    private String machineId;
    private String description;

    public LogMessage(String message) {
        // 1. find where ':' appears in message
        int colonIndex = message.indexOf(":");
        // 2. find substring for machineId, begin at index 0, end at index of ':' -1
        this.machineId = message.substring(0, colonIndex);
        // 3. find substring for description, begin at index of ':' +1, length of message -1
        this.description = message.substring(colonIndex+1, message.length());
    }

    public String getMachineId() {
        return machineId;
    }

    public String getDescription() {
        return description;
    }

    public boolean containsWord(String keyword) {
        String newDescription = description;
        int keywordIndex = newDescription.indexOf(keyword);
        boolean result = containsWordFirstOccurrence(keyword, newDescription);

        while (keywordIndex != -1 && !result) {
            newDescription = newDescription.substring(keywordIndex+keyword.length());
            keywordIndex = newDescription.indexOf(keyword);
            result = containsWordFirstOccurrence(keyword, newDescription);
        }

        return result;
    }

    private boolean containsWordFirstOccurrence(String keyword, String newDescription) {
        boolean result = false;

        int keywordIndex = newDescription.indexOf(keyword);

        if (keywordIndex != -1) {
            if (keywordIndex == 0 || newDescription.substring(keywordIndex-1, keywordIndex).equals(" ")) {
                if (keywordIndex+keyword.length() == newDescription.length() ||
                        newDescription.substring(keywordIndex+keyword.length(), keywordIndex+keyword.length()+1).equals(" ")) {
                    result = true;
                }

            }
        }

        return result;
    }

}
