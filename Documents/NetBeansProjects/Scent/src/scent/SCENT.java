/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scent;
/**
 *
 * @author Foklourng
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import com.google.gson.*;
import com.google.gson.reflect.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;

public class SCENT {
    public static String temp, WT,WTD,city,country;
    /**
     * @param args the command line arguments
     */
    
    public static Map<String,Object> jsonToMap(String str) throws IOException{
        Map<String,Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType());
    return map;
    }
    
    
    public static void weather() throws MalformedURLException, IOException {
        // TODO code application logic here
       
         String LOCATION="";
        Scanner scnr = new Scanner(System.in);
        try{
        System.out.println("Enter 'city,country'");
        LOCATION = scnr.nextLine();
        
       // System.out.println("City and country " + LOCATION);
        String API_KEY = "92b7ae50bd1768ee65272e9aa208fc25";
        
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=imperial";  
        
        String urlStringF = "http://api.openweathermap.org/data/2.5/forecast?q=" + LOCATION + "&appid=" + API_KEY + "&units=imperial";
        
                  
              StringBuilder result = new StringBuilder();
              URL url = new URL(urlString);
              URLConnection conn = url.openConnection();
              BufferedReader rd = new BufferedReader(new InputStreamReader (conn.getInputStream()));
              String line;
              while ((line = rd.readLine()) != null){
                  result.append(line);
              }
              
              
              
              StringBuilder result_F = new StringBuilder();
              URL urlF = new URL(urlStringF);
              URLConnection conn1 = urlF.openConnection();
              BufferedReader rd1 = new BufferedReader(new InputStreamReader (conn1.getInputStream()));
              String line1;
              while ((line1 = rd1.readLine()) != null){
                  result_F.append(line1);
              }
              rd.close();
              rd1.close();
              System.out.println("Result 5 days forecast " +result_F);
              
              
              System.out.println(result);
             
              
          Map<String, Object > respMap = jsonToMap (result.toString());
          Map<String, Object > mainMap = (Map<String, Object >)respMap.get("main");
          Map<String, Object > sysMap = (Map<String, Object >)respMap.get("sys");
          String  nameMap = (String) respMap.get("name");
          List<Map<String, Object >> weather = (List<Map<String, Object>>) (respMap.get("weather"));
          Map<String, Object> weatherMap = weather.get(0);
          
          temp = ""+ mainMap.get("temp");
          WT = ""+ weatherMap.get("main");
          WTD = ""+ weatherMap.get("description");
          city= ""+nameMap;
          country = ""+ sysMap.get("country");
          System.out.println("City: " + nameMap + ", Country: " + sysMap.get("country"));          
                
          System.out.println("Description: "+ weatherMap.get("description"));          
          System.out.println("Current Temperature: " + mainMap.get("temp")  );
         
		}catch(IOException e)
                {
                    //System.out.println(e.getMessage());
                    System.out.println("Invalid Input");
                    System.exit(0);
                }        
        }
        
        
        
    
    
    
}
