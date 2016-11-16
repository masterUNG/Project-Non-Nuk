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

public class AddUserTABLE extends AsyncTask<String, Void, String>{

    //Explicit
    private Context context;
    private int anInt;


    public AddUserTABLE(Context context, int anInt) {
        this.context = context;
        this.anInt = anInt;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("User", strings[1])
                    .add("Password", strings[2])
                    .add("Position", Integer.toString(anInt))
                    .add("Phone", strings[3])
                    .add("Email", strings[4])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("16novV1", "e doIn ==> " + e.toString());
            return null;
        }


    }   // doInBack

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("16novV1", "Result ==> " + s);

    }   // onPost


}   // Main Class
