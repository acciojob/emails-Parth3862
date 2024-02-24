package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity;
    private  ArrayList<Mail> inbox;
    private  ArrayList<Mail> trash;

    //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String).
    // It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.inbox = new ArrayList<>();
        this.trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(inbox.size()>=inboxCapacity){
            moveOldestMailToTrash();
        }
        inbox.add(new Mail(date,sender,message));
    }
    public void moveOldestMailToTrash(){
        Mail oldestMail = inbox.get(0);
        for (Mail mail:inbox){
            if(mail.getDate().before(oldestMail.getDate())){
                oldestMail=mail;
            }
        }
        inbox.remove(oldestMail);
        trash.add(oldestMail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(Mail mail:inbox){
            if(mail.getMessage().equals(message)){
                trash.add(mail);
                inbox.remove(mail);
                break;
            }
        }
    }

    public String findLatestMessage() {
        // If the inbox is empty, return null
        if (!inbox.isEmpty()) {
            // Return the message of the last (latest) mail present in the inbox
            return inbox.get(inbox.size() - 1).getMessage();
        } else {
            return null;
        }
    }

    public String findOldestMessage() {
        if (!inbox.isEmpty()) {
            return inbox.get(0).getMessage();
        } else {
            return null;
        }
    }
    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        int count=0;
        for(Mail mail:inbox){
            if (mail.getDate().compareTo(start)>=0 && mail.getDate().compareTo(end)<=0) {
                count++;
            }
        }
        return count;
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
