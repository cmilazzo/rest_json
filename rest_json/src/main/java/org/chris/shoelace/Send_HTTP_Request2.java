package org.chris.shoelace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String url = "http://api.ipinfodb.com/v3/ip-city/?key=782e96d9c2e9b2d19e5a495bb36be25ec56d59a913e0cadf4b6521502b971d97&ip=174.63.108.242&format=json";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     
     JSONParser parser = new JSONParser();

     //Read JSON response and print
     try {

    	 Object obj2 = parser.parse(response.toString());

         JSONObject jsonObject = (JSONObject) obj2;
         System.out.println(jsonObject);
         
         String name = (String) jsonObject.get("zipCode");
         System.out.println(name);

         String age = (String) jsonObject.get("cityName");
         System.out.println(age);


     } catch (ParseException e) {
         e.printStackTrace();
     }
}
}
