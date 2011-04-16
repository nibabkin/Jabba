package ru.nibabkin.jabba.ui.chat;

import java.util.ArrayList;

import ru.nibabkin.jabba.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
