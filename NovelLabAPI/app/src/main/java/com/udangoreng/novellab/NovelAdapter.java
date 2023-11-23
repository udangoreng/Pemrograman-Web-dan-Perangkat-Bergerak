package com.udangoreng.novellab;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelViewHolder>{
    public class NovelViewHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout containerView;
        private TextView titleView, writerView, yearView;
        private WebView imageView;
        public NovelViewHolder(@NonNull View thisView) {
            super(thisView);
            containerView = thisView.findViewById(R.id.novel_item);
            titleView = thisView.findViewById(R.id.title_textView);
            writerView = thisView.findViewById(R.id.writer_textView);
            yearView = thisView.findViewById(R.id.year_textView);
            imageView = thisView.findViewById(R.id.imageView);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Novel current = (Novel) containerView.getTag();
                    Intent intent = new Intent(view.getContext(), SecondActivity.class);
                    intent.putExtra("title", current.getTitle());
                    intent.putExtra("writer", current.getWriter());
                    intent.putExtra("year", current.getYear());
                    intent.putExtra("image", current.getCover());
                    intent.putExtra("desc", current.getSynopsis());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }


    private List<Novel> novels = new ArrayList<>();
    private RequestQueue requestQueue;

    NovelAdapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        getAllBooks();
    }
    //Get Data From API
    public void getAllBooks (){
        String url = "https://www.googleapis.com/books/v1/volumes?q=''&key=AIzaSyA6SaT23KNiiA6DnUfUQTvFeyAcQEkwnSU&maxResults=10";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String description, year, writer;
                    JSONArray items = response.getJSONArray("items");
                    for(int i = 0; i < items.length(); i++) {
                        JSONObject res = items.getJSONObject(i);
                        JSONObject info = res.getJSONObject("volumeInfo");

                        String name = info.getString("title");

                        // Check if data contains authors
                        if (info.toString().contains("authors")) {
                            writer = info.getJSONArray("authors").getString(0);
                        } else if (info.toString().contains("publisher")) {
                            writer = info.getString("publisher");
                        } else {
                            writer = "-";
                        }

                        String image = info.getJSONObject("imageLinks").getString("thumbnail");

                        if (info.toString().contains("description")) {
                            description = info.getString("description");
                        } else {
                            description = "-";
                        }

                        if (info.toString().contains("publishedDate")) {
                            year = info.getString("publishedDate").substring(0,4);
                        } else {
                            year = "-";
                        }

                        novels.add(new Novel(
                                name, writer, description, image, year
                        ));
                    } notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e("ApiError", "Error Fetching Data", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ApiError", "Overall Error Fetching Data");
            }
        });
        requestQueue.add(request);
    }

    @NonNull
    @Override
    public NovelAdapter.NovelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_items, parent, false);
        return new NovelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelAdapter.NovelViewHolder holder, int position) {
        String text;
        Novel current = novels.get(position);
        if (current.getTitle().length() > 20 ){
            text = current.getTitle().substring(0, 20) + "...";
        } else {
            text = current.getTitle();
        }
        holder.titleView.setText(text);
        holder.writerView.setText(current.getWriter());
        holder.yearView.setText(current.getYear());
        holder.imageView.loadUrl(current.getCover());
        holder.imageView.getSettings().setLoadWithOverviewMode(true);
        holder.imageView.getSettings().setUseWideViewPort(true);
        holder.containerView.setTag(current);

    }

    @Override
    public int getItemCount() {
        return novels.size();
    }
}
