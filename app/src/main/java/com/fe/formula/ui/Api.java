package com.fe.formula.ui;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Api
{
    private static final String key="your api";
    private static Postlist postlist=null;
    private static String url="";



    public interface  Postlist
    {
        @GET("="key)
        Call<Example> getpost();
    }


    public static Postlist getPostserivice() {
        if (postlist== null) {
            postlist = (Postlist) new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build().create(Postlist.class);
        }
        return postlist;
    }
}
