package ru.nibabkin.jabba.ui.chat;

import java.util.ArrayList;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;

import ru.nibabkin.jabba.R;
import ru.nibabkin.jabba.xmpp.XmppConnector;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatListActivity extends ListActivity 
		implements OnClickListener, PacketListener{
	private String contactName;
	private Button sendButton;
	private ArrayList<ChatListItem> chatList;
	private ChatListAdapter chatAdapter;
	private EditText newMessage;
	
	public ChatListActivity() {
		
	}
	
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
		String to = contactName;
        String text = newMessage.getText().toString();

        XMPPConnection connection = XmppConnector.connection;
        
        Log.i("XMPPClient", "Sending text [" + text + "] to [" + to + "]");
        Message msg = new Message(to, Message.Type.chat);
        msg.setBody(text);
        connection.sendPacket(msg);
        
        
        chatList.add(new ChatListItem(connection.getUser() + ":", text));
       
		chatAdapter.notifyDataSetChanged();
		newMessage.setText(null);
	}

	public void processPacket(Packet packet) {
		Message message = (Message) packet;
        if (message.getBody() != null) {
            String fromName = StringUtils.parseBareAddress(message.getFrom());
            Log.i("XmppConnector", "Got text [" + message.getBody() + "] from [" + fromName + "]");
            chatList.add(new ChatListItem(fromName + ":", message.getBody()));
            
            chatAdapter.notifyDataSetChanged();
        }
		
	}
}
