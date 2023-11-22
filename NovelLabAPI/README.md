# NovelLab

Project ini adalah pengembangan aplikasi NovelLab dengan data yang diambil dari API menggunakan library Volley.

Untuk mengambil API dengan library tersebut sebagai berikut :
```
   private RequestQueue requestQueue;

    NovelAdapter(Context context){
        requestQueue = Volley.newRequestQueue(context);
        getAllBooks();
    }

    public void getAllBooks (){
        String url = "https://www.googleapis.com/books/v1/volumes?q=''&key=AIzaSyA6SaT23KNiiA6DnUfUQTvFeyAcQEkwnSU&maxResults=10";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String description;
                    JSONArray items = response.getJSONArray("items");
                    for(int i = 0; i < items.length(); i++) {
                        JSONObject res = items.getJSONObject(i);
                        JSONObject info = res.getJSONObject("volumeInfo");
                        Log.d("ApiError", info.getString("publishedDate").substring(0, 4));
                        String name = info.getString("title");
                        String writer = info.getJSONArray("authors").getString(0);
                        String image = info.getJSONObject("imageLinks").getString("thumbnail");
                        if (info.toString().contains("description")) {
                            description = info.getString("description");
                        } else {
                            description = "-";
                        }
                        int year = Integer.valueOf(info.getString("publishedDate").substring(0, 4));

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

```
