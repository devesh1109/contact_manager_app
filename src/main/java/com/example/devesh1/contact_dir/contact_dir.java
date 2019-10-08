package com.example.devesh1.contact_dir;

import android.app.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class contact_dir extends AppCompatActivity {
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_dir);



        sv= (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter adapter=new MyAdapter(this,getPlayers());
        rv.setAdapter(adapter);
        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
    //ADD PLAYERS TO ARRAYLIST
    private ArrayList<myDataSet> getPlayers()
    {
        ArrayList<myDataSet> contact=new ArrayList<>();
        myDataSet p=new myDataSet();
        p.setName("Ander Herera");
        p.setPos("Midfielder");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        p=new myDataSet();
        p.setName("David De Geaa");
        p.setPos("Goalkeeper");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        p=new myDataSet();
        p.setName("Michael Carrick");
        p.setPos("Midfielder");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        p=new myDataSet();
        p.setName("Juan Mata");
        p.setPos("Playmaker");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        p=new myDataSet();
        p.setName("Diego Costa");
        p.setPos("Striker");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        p=new myDataSet();
        p.setName("Oscar");
        p.setPos("Playmaker");
        p.setImg(R.drawable.ronaldo);
        contact.add(p);
        return contact;
    }
}
