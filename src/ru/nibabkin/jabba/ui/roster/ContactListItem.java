package ru.nibabkin.jabba.ui.roster;

public class ContactListItem {
    
	public int contactIconId;
    public String contactName;
    public String contactStatus;
    
    public ContactListItem(int iconId, String name, String status){
    	contactIconId = iconId;
    	contactName = name;
    	contactStatus = status;
    }
}