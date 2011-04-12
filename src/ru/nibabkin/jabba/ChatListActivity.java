package ru.nibabkin.jabba;

import android.app.ListActivity;
import android.os.Bundle;

public class ChatListActivity extends ListActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);
    }
}
