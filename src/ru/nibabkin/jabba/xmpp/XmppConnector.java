package ru.nibabkin.jabba.xmpp;

import java.util.ArrayList;

import ru.nibabkin.jabba.R;
import ru.nibabkin.jabba.ui.roster.ContactListItem;

public class XmppConnector {
	public void putContacts(ArrayList<ContactListItem> contacts) {		
		contacts.add(new ContactListItem(R.drawable.icon, "Jacob Anderson", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Emily Duncan", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Emma Greemnan", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Joshua Harrison", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Madison Johnson", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Matthew Cotman", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Olivia Lawson", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Andrew Chapman", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Michael Honeyman", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Isabella Jackson", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "William Patterson", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Joseph Godwin", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Samanta Bush", "ololo"));
		contacts.add(new ContactListItem(R.drawable.icon, "Christopher Gateman", "ololo"));
	}
}