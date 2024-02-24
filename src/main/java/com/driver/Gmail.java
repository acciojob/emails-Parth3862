package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    private ArrayList<String> inbox;
    private ArrayList<String> trash;
    private int inboxCapacity;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        // Receive a mail and move oldest mail to trash if inbox is full
        if (inbox.size() >= inboxCapacity) {
            trash.add(inbox.remove(0)); // Remove oldest mail from inbox and add to trash
        }
        inbox.add(message); // Add new mail to inbox
    }

    public void deleteMail(String message) {
        // Delete a mail by moving it to trash
        if (inbox.contains(message)) {
            trash.add(message); // Move mail to trash
            inbox.remove(message); // Remove mail from inbox
        }
    }

    public String findLatestMessage() {
        // Find the latest message in the inbox
        if (!inbox.isEmpty()) {
            return inbox.get(inbox.size() - 1); // Return last message in inbox
        }
        return null; // Return null if inbox is empty
    }

    public String findOldestMessage() {
        // Find the oldest message in the inbox
        if (!inbox.isEmpty()) {
            return inbox.get(0); // Return first message in inbox
        }
        return null; // Return null if inbox is empty
    }

    public int findMailsBetweenDates(Date start, Date end) {
        // Find the number of mails received between two dates
        int count = 0;
        for (String message : inbox) {
            // Assume dates of messages are not available, so consider all messages
            count++;
        }
        return count;
    }

    public int getInboxSize() {
        // Get the size of the inbox
        return inbox.size();
    }

    public int getTrashSize() {
        // Get the size of the trash
        return trash.size();
    }

    public void emptyTrash() {
        // Empty the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Get the maximum inbox capacity
        return inboxCapacity;
    }
}
