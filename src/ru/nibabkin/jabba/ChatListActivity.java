package ru.nibabkin.jabba;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatListActivity extends ListActivity implements OnClickListener{
	private String contactName;
	private Button sendButton;
	private ArrayList<ChatListItem> chatList;
	private ChatListAdapter chatAdapter;
	private EditText newMessage;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
        
        Intent launchIntent = getIntent();
        Bundle launchInfo = launchIntent.getExtras();
        
        contactName = launchInfo.getString("ContactName");
        
        final TextView header = (TextView)findViewById(R.id.chat_header_textview);
        header.setText(contactName);
        
        sendButton = (Button)findViewById(R.id.send_button);
        sendButton.setOnClickListener(this);
        
        chatList = new ArrayList<ChatListItem>();
        chatAdapter = new ChatListAdapter(this, R.layout.chat_list_item, chatList);
        setListAdapter(chatAdapter);
        
        newMessage = (EditText)findViewById(R.id.new_message_edittext);
        
    }

	public void onClick(View element) {
		chatList.add(new ChatListItem("Nikita Babkin", newMessage.getText().toString()));
		chatAdapter.notifyDataSetChanged();
		newMessage.setText(null);
		
		chatList.add(new ChatListItem(contactName, "Yes!"));
		chatAdapter.notifyDataSetChanged();
	}
}

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

class ChatListItem {
    
	public String messageMark;
    public String message;
    
    public ChatListItem(String mark, String message){
    	this.message = message;
    	messageMark = mark;
    }
}
