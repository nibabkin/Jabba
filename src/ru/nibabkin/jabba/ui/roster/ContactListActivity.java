package ru.nibabkin.jabba.ui.roster;

import java.util.ArrayList;

import org.jivesoftware.smack.PacketListener;

import ru.nibabkin.jabba.R;
import ru.nibabkin.jabba.ui.chat.ChatListActivity;
import ru.nibabkin.jabba.xmpp.XmppConnector;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ContactListActivity extends ListActivity implements OnClickListener {
	private XmppConnector xmpp;
	private ArrayList<ContactListItem> contactList;
	private ContactListAdapter contactListAdapter;
	private boolean isConnected;
	
	private ChatListActivity chat;
	
	private Button connect;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        contactList = new ArrayList<ContactListItem>();
        chat = new ChatListActivity();
        xmpp = new XmppConnector((PacketListener)chat);
        xmpp.putContacts(contactList);
        
        contactListAdapter = new ContactListAdapter(this.getApplicationContext(), R.layout.contact_list_item, contactList);
        setListAdapter(contactListAdapter);
        
        isConnected = true;
        
        connect = (Button)findViewById(R.id.connect_button);
        connect.setOnClickListener(this);
        
        connect.setText(R.string.disconnect);
    }

	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.connect_button:
			if (isConnected) {
				contactList.clear();
				contactListAdapter.notifyDataSetChanged();
				connect.setText(R.string.connect);
				isConnected = false;
			}
			else {
				xmpp.putContacts(contactList);
				contactListAdapter.notifyDataSetChanged();
				connect.setText(R.string.disconnect);
				isConnected = true;
			}
			break;
		default:
			//Nothing to be done there
		}
	}
	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		Intent chatIntent = new Intent(this, ChatListActivity.class);
		ContactListItem contact = contactList.get(position);
		chatIntent.putExtra("ContactName", contact.contactName);
		startActivity(chatIntent);
		chat.startActivity(chatIntent);
	}
}

