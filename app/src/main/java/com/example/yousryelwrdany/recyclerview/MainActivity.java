package com.example.yousryelwrdany.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String link="http://simplifiedcoding.net/demos/marvel/";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<ListItem> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listItems = new ArrayList<>();

        loadDataFromWeb();

    }

    private void loadDataFromWeb() {

        StringRequest request = new StringRequest(link, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    JSONArray myArray = new JSONArray(response);
                    for(int x=0 ; x < myArray.length() ; x++){
                        final JSONObject myObject = myArray.getJSONObject(x);
                        String name = myObject.getString("name");
                        String bio = myObject.getString("bio");
                        String img = myObject.getString("imageurl");
                        listItems.add(new ListItem(name,bio,img));
                        adapter = new MyAdapter(listItems,getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }

                }catch(Exception e){
                    e.getLocalizedMessage().toString();
                }

            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);



    }
}
