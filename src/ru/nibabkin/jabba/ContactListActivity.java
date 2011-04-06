package ru.nibabkin.jabba;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactListActivity extends ListActivity implements OnClickListener {
	private XMPPConnector xmpp;
	private ArrayList<ContactListItem> contactList;
	private ContactListAdapter contactListAdapter;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        contactList = new ArrayList<ContactListItem>();
        xmpp = new XMPPConnector();
        xmpp.putContacts(contactList);
        
        contactListAdapter = new ContactListAdapter(this.getApplicationContext(), R.layout.contact_list_item, contactList);
        setListAdapter(contactListAdapter);
        
        final Button connect = (Button)findViewById(R.id.connect_button);
        connect.setOnClickListener(this);
        
        final Button disconnect = (Button)findViewById(R.id.disconnect_button);
        disconnect.setOnClickListener(this);
    }

	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.connect_button:
			xmpp.putContacts(contactList);
			contactListAdapter.notifyDataSetChanged();
			break;
		case R.id.disconnect_button:
			contactList.clear();
			contactListAdapter.notifyDataSetChanged();
		}
		
	}
}

class ContactListAdapter extends ArrayAdapter<ContactListItem> {
	private ArrayList<ContactListItem> listItems;
	private Context context;
	
	public ContactListAdapter(Context ctx, int itemLayoutId, ArrayList<ContactListItem> items) {
		super(ctx, itemLayoutId, items);
		listItems = items;
		context = ctx;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.contact_list_item, null);
        }
        
        ContactListItem item = listItems.get(position);
        if (item != null) {
        	
        	ImageView image = (ImageView)view.findViewById(R.id.contact_image);
        	TextView name = (TextView)view.findViewById(R.id.contact_name);
        	TextView status = (TextView)view.findViewById(R.id.contact_status);
        	
        	image.setImageResource(item.contactIconId);
        	name.setText(item.contactName);
        	status.setText(item.contactStatus);
        }
        return view;
	}
}

class ContactListItem {
    
	public int contactIconId;
    public String contactName;
    public String contactStatus;
    
    public ContactListItem(int iconId, String name, String status){
    	contactIconId = iconId;
    	contactName = name;
    	contactStatus = status;
    }
}

class XMPPConnector {
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