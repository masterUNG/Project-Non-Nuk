package com.example.n56j.project1;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 11/16/2016 AD.
 */

public class GetUser extends AsyncTask<String, Void, String>{

    //Explicit
    private Context context;
    private int anInt; // 0==> admin, 1==>user

    public GetUser(Context context, int anInt) {
        this.context = context;
        this.anInt = anInt;
    }   // Constructor

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Position", Integer.toString(anInt))
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("16novV2", "e doIn ==> " + e.toString());
            return null;
        }

    }   // doIn

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }   // onPost

}   // Main Class
