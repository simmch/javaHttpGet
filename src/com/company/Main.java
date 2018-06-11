package com.company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class Main {


    private static HttpURLConnection con;

    public static void main(String[] args) throws MalformedURLException,
            ProtocolException, IOException, JSONException {

        // URL ENDPOINT
        String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cardbacks";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");
            // API KEY PARAMETER
            con.setRequestProperty("X-Mashape-Key", "GGlbpdx5XCmshkmgWQ8gCAJ1fRyFp1eInyMjsnnUBHYrYmXUX4");

            StringBuilder response;

            // USE THIS VARIABLE WHEN RUNNING PROGRAM
            // FOR SINGLE OBJECT TESTING
            String name;

            ArrayList <String> listData = new ArrayList<String>();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                response = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
            }

            // SINGLE OBJECT TESTING
             JSONObject obj =  new JSONArray(response.toString()).getJSONObject(0);
             name = obj.getString("name");
             System.out.println(name);

            // ARRAY LIST TESTING
            // JSONArray arr = new JSONArray(response.toString());
            // for (int i = 0; i < arr.length(); i++) {
            //    listData.add(arr.getJSONObject(i).toString());
            // }

            // System.out.println(arr.get(6));

        }  finally {

            con.disconnect();
        }

    }

}

