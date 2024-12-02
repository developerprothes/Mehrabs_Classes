package com.aspprothes.listviewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();
    private HashMap<String,String> myhashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getResources().getColor(R.color.sky));
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        myhashMap = new HashMap<>();
        myhashMap.put("names","Mehrab");
        myhashMap.put("description","He is Good Student");
        arrayList.add(myhashMap);


        myhashMap = new HashMap<>();
        myhashMap.put("names","Prothes");
        myhashMap.put("description","He is a Boy");
        arrayList.add(myhashMap);


        myhashMap = new HashMap<>();
        myhashMap.put("names","Shafin");
        myhashMap.put("description","He is a Good Boy");
        arrayList.add(myhashMap);



        CustomListViewBaseAdapter customListViewBaseAdapter = new CustomListViewBaseAdapter();
        listView.setAdapter(customListViewBaseAdapter);

    }
    // ========================================= On Create Method End Here ====================================









    public class CustomListViewBaseAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return arrayList.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null){
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.listview_items_design,parent,false);
            }
            TextView titles_name = convertView.findViewById(R.id.title);
            TextView des_name = convertView.findViewById(R.id.des);

            HashMap<String,String> hashMap = new HashMap<>();
            hashMap = arrayList.get(position);

            String getNames = hashMap.get("names");
            String getDes = hashMap.get("description");

            titles_name.setText(""+getNames);
            des_name.setText(""+getDes);


            return convertView;
        }
    }












}