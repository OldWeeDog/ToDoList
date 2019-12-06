package com.example.todolist;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataHelper {

    public static ArrayList<pml> loadPml(Context context) {
        ArrayList<pml> pmls = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("toDo.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("savedLists");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                /*
                Create new instance of the pml class
                 */
                pml pml = new pml();
                pml.setTitle(jsonObject.getString("title"));
                pml.setTdl(jsonObject.getString("tdl"));

                pmls.add(pml);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
          Return list that was made
          */
        return pmls;

    }


}
