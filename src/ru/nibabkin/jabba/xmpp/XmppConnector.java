package ru.nibabkin.jabba.xmpp;

import java.util.ArrayList;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import android.util.Log;

import ru.nibabkin.jabba.R;
import ru.nibabkin.jabba.ui.roster.ContactListItem;

public class XmppConnector {
	private PacketListener packetListener; 
	public static XMPPConnection connection;
	
	public XmppConnector(PacketListener packetListener) {
		this.packetListener = packetListener;
	}
	
	public void connect() {
		String host = "talk.google.com";
		int port = 5222;
		String service = "gmail.com";
		String username = "nibabkin@gmail.com";
		String password = "nikBab1!";
		
		ConnectionConfiguration connConfig = new ConnectionConfiguration(host, port, service);
		XMPPConnection connection = new XMPPConnection(connConfig);
		
		try {
            connection.connect();
            Log.i("XMPPClient", "[XmppConnector] Connected to " + connection.getHost());
        } catch (XMPPException ex) {
            Log.e("XMPPClient", "[XmppConnector] Failed to connect to " + connection.getHost());
            Log.e("XMPPClient", ex.toString());
        }
        
        try {
            connection.login(username, password);
            Log.i("XMPPClient", "Logged in as " + connection.getUser());

            // Set the status to available
            Presence presence = new Presence(Presence.Type.available);
            connection.sendPacket(presence);
            setConnection(connection);
        } catch (XMPPException ex) {
            Log.e("XMPPClient", "[XmppConnector] Failed to log in as " + username);
            Log.e("XMPPClient", ex.toString());
            setConnection(null);
        }  
	}
	
	public void setConnection (XMPPConnection connection) {
		XmppConnector.connection = connection;
		if (XmppConnector.connection != null) {
		    // Add a packet listener to get messages sent to us
		    PacketFilter filter = new MessageTypeFilter(Message.Type.chat);
		    XmppConnector.connection.addPacketListener(packetListener, filter);
		}
	}
	
	public void putContacts(ArrayList<ContactListItem> contacts) {		
		contacts.add(new ContactListItem(R.drawable.icon, "nikita.u.babkin@yandex.ru", "ololo"));
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