package com.udangoreng.divanandaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTextView, numberTextView, typeTextView;
    private ImageView pokeImageView;
    private RequestQueue requestQueue;

    String url;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        int img = intent.getIntExtra("images", 0);
        nameTextView = (TextView) findViewById(R.id.namePoke);
        numberTextView = (TextView) findViewById(R.id.numberPoke);
        typeTextView = (TextView) findViewById(R.id.typePoke);
        load();

        nameTextView.setText(url);
    }

    public void load(){
        nameTextView.setText("");
        numberTextView.setText("");
        typeTextView.setText("");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray results;
                try {
                    nameTextView.setText(response.getString("name"));
                    JSONArray types = response.getJSONArray("types");
                    for (int i = 0; i < types.length(); i++) {
                        JSONObject typeEntry = types.getJSONObject(i);
                        int slots = typeEntry.getInt("slot");
                        String type = typeEntry.getJSONObject("type").getString("name");

                        if (slots == 1){
                            numberTextView.setText(type);
                        } else if (slots == 2) {
                            typeTextView.setText(type);
                        }
                    }
                } catch (JSONException e) {
                    Log.e("ErrAPI", "Error Fetching API", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrAPI", "Error Getting That");
            }
        });
        requestQueue.add(request);
    }

    public void done(){
        finish();
    }
}