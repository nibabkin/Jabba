package ru.nibabkin.jabba.ui.roster;

import java.util.ArrayList;

import ru.nibabkin.jabba.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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