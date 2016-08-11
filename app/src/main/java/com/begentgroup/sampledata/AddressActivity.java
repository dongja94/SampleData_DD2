package com.begentgroup.sampledata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class AddressActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<Person> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.clear();
        List<Person> list = DBManager.getInstance().getPersonList(null);
        mAdapter.addAll(list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_address, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            startActivity(new Intent(this, AddressAddActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
