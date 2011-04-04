package ru.nibabkin.jabba;

import android.app.ListActivity;
import android.os.Bundle;

public class ContactListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}