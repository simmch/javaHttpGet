package com.company;

import org.json.JSONArray;
import org.json.JSONException;

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

        String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cardbacks";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("X-Mashape-Key", "GGlbpdx5XCmshkmgWQ8gCAJ1fRyFp1eInyMjsnnUBHYrYmXUX4");

            StringBuilder response;

            String name;

            ArrayList <String> listData = new ArrayList<String>();

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                response = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    response.append(line);
//                    response.append(System.lineSeparator());
                }
            }

            // SINGLE OBJECT
//            JSONObject obj =  new JSONArray(response.toString()).getJSONObject(0);
//            name = obj.getString("name");
//            System.out.println(name);

            // ARRAY
            JSONArray arr = new JSONArray(response.toString());
            for (int i = 0; i < arr.length(); i++) {
                listData.add(arr.getJSONObject(i).toString());
            }

            System.out.println(arr.get(6));




        }  finally {

            con.disconnect();
        }

    }


//int[] a = {1234, 4321};
//int[] b = {4532, 3214};


//    Scanner scan = new Scanner(System.in);
//    int i = 1;
//        while (scan.hasNext()) {
//            System.out.println(i + " " + scan.nextLong());
//            i++;
//        }
//        scan.close();


//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//
//        for(int i = 0; i<t; i++) {
//
//        } try {
//            long x = sc.nextLong();
//            System.out.println(x+" can be fitted in: ");
////            if(x>= -128 && x<= 127) System.out.println("* byte");
//            if(x>= Byte.MIN_VALUE && x <= Byte.MAX_VALUE)
//                System.out.println("* byte.");
//            if(x>= Short.MIN_VALUE && x <= Short.MAX_VALUE)
//                System.out.println("* short.");
//            if(x>= Integer.MIN_VALUE && x <= Integer.MAX_VALUE)
//                System.out.println("* int.");
//            if(x>= Long.MIN_VALUE && x <= Long.MAX_VALUE)
//                System.out.println("* long.");
//        } catch (Exception e) {
//            System.out.println(sc.next() + "It can't be fitted anywhere!");
//
//        }

//    Scanner in = new Scanner(System.in);
//    int N = in.nextInt();
//
//    for(int i = 1; i <= 10; i++){
//        int result = N*i;
//        System.out.printf("%d x %d = %d\n",N,i,result);
//    }

//        String name = "";
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("================================");
//        for(int i=0; i<3; i++){
//            String s1 = scan.nextLine();
//            int x = scan.nextInt();
//            System.out.printf("%-15s%03d",s1,x);
//        }
//        System.out.println("================================");


//        int[] people = {1,5,6,7};
//
//        int total = 0;
//
//
//        // Enhanced for loop
//        for(int i: people){
//            total += i;
//            System.out.println(total);
//        }
}

