package com.fe.formula.ui;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api
{
    private static final String key="AIzaSyBBjzl60xFsfR3_xTygmQF2QS0Tyq80vrs";
    private static Postlist postlist=null;
    private static String url="https://www.googleapis.com/";



    public interface  Postlist
    {
        @GET("blogger/v3/blogs/923828349976312167/posts?key="+key)
        Call<Example> getpost();
    }


    public static Postlist getPostserivice() {
        if (postlist== null) {
            postlist = (Postlist) new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build().create(Postlist.class);
        }
        return postlist;
    }
}
