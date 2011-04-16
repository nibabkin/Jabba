package ru.nibabkin.jabba.ui.chat;

import java.util.ArrayList;

import ru.nibabkin.jabba.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class ChatListAdapter extends ArrayAdapter<ChatListItem> {
	private ArrayList<ChatListItem> listItems;
	private Context context;
	
	public ChatListAdapter(Context ctx, int itemLayoutId, ArrayList<ChatListItem> items) {
		super(ctx, itemLayoutId, items);
		listItems = items;
		context = ctx;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.chat_list_item, null);
        }
        
        ChatListItem item = listItems.get(position);
        if (item != null) {
        	
        	TextView mark = (TextView)view.findViewById(R.id.chat_mark);
        	TextView message = (TextView)view.findViewById(R.id.chat_message);
        	
        	mark.setText(item.messageMark + ":");
        	message.setText(item.message);
        }
        return view;
	}
}