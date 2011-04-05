package ru.nibabkin.jabba;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ContactListActivity extends ListActivity implements OnClickListener {
	private XMPPConnector xmpp;
	private ArrayAdapter<String> contactListAdapter;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        xmpp = new XMPPConnector();
        
        final Button connect = (Button)findViewById(R.id.connect_button);
        connect.setOnClickListener(this);
        
        final Button disconnect = (Button)findViewById(R.id.disconnect_button);
        disconnect.setOnClickListener(this);
    }

	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.connect_button:
			contactListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,xmpp.getContacts());
			setListAdapter(contactListAdapter);
			
			break;
		case R.id.disconnect_button:
			setListAdapter(null);
		}
		
	}
}

class XMPPConnector {
	public String[] getContacts() {
		String[] contacts = {"Jacob Anderson", "Emily Duncan",
				"Emma Greemnan", "Joshua Harrison", "Madison Johnson",
				"Matthew Cotman", "Olivia Lawson", "Andrew Chapman",
				"Michael Honeyman", "Isabella Jackson", "William Patterson",
				"Joseph Godwin", "Samanta Bush", "Christopher Gateman"};
		return contacts;
	}
}