package ru.nibabkin.jabba.ui.chat;

public class ChatListItem {
    
	public String messageMark;
    public String message;
    
    public ChatListItem(String mark, String message){
    	this.message = message;
    	messageMark = mark;
    }
}