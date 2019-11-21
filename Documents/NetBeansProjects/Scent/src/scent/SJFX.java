/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;        
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.effect.ImageInput; 
import javafx.scene.image.Image; 
import javafx.scene.shape.Rectangle; 
import javafx.scene.image.ImageView; 
import java.util.Calendar;
/**
 *
 * @author Foklourng
 */
public class SJFX extends Application{
    Button button, butt2,butt3,butt4;
    Button buttW1,buttW2,buttW3,buttW4,buttW5;
    Stage window;
    Scene scene1, scene2;
    SCENT obj1 = new SCENT();
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        launch(args);
        
    }
    
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Scent Diffuser");
       //String a="";
       //a = obj1.country + "/" + obj1.city;
        //run weather function
        obj1.weather();
        //Label on Main scene
        Label l1 = new Label("SCENT STRATOSPHERE"); 
        Label l2 = new Label("Current Weather in "+ obj1.city + " , " + obj1.country ); 
        Label l3 = new Label(obj1.WTD + " Temp : " + obj1.temp + " F"); 
        Label l4 = new Label(getDate_Time()); 
        Label l5 = new Label("Recommended Scent: " + getScent(obj1.WT));
        
        String img1,img2,img3,img4,img5;
        
        img1 = "C:\\Users\\muy heng\\Desktop\\cloudy.png";
        img2 = "C:\\Users\\muy heng\\Desktop\\sunny.png";
        img3 = "C:\\Users\\muy heng\\Desktop\\rainy.png";
        img4 = "C:\\Users\\muy heng\\Desktop\\snowy.png";
        img5 = "C:\\Users\\muy heng\\Desktop\\thunder.png";
        
        
        
        //User Input
        TextInputDialog td = new TextInputDialog("Enter Event");
        
       //Weathre condition image checker 
       Image image;
       if(obj1.WT.equals("Clouds"))
           image = new Image(new FileInputStream(img1)); 
       else if(obj1.WT.equals("Clear"))
           image = new Image(new FileInputStream(img2));
       else if(obj1.WT.equals("Rain"))
           image = new Image(new FileInputStream(img3));
       else if(obj1.WT.equals("Snow"))
           image = new Image(new FileInputStream(img4));
       else if(obj1.WT.equals("Drizzle"))
           image = new Image(new FileInputStream(img3));
       else if(obj1.WT.equals("Thunderstorm"))
           image = new Image(new FileInputStream(img5));
       else 
           image = new Image(new FileInputStream("C:\\Users\\muy heng\\Desktop\\sunny.png"));

        
             
     
      //Instantiating the ImageInput class 
      ImageView imageInput = new ImageView(image); 
      
      //Setting the position of the image
      imageInput.setX(1); 
      imageInput.setY(1); 
      
      imageInput.setFitHeight(100);
      imageInput.setFitWidth(100);
      
      //Setting source for image input  
      imageInput.setPreserveRatio(true); 
       
        
        
        VBox vbox2 = new VBox(20);
        vbox2.setAlignment(Pos.TOP_CENTER);

        vbox2.setPadding(new Insets(20,10,20,10));
        
        window = primaryStage;
        
        VBox vbox= new VBox(12);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setPadding(new Insets(20,10,20,10));
        
        button = new Button("Scent Info");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        button.setPadding(new Insets(10,60,10,60));
        button.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        
        butt3 = new Button("Add Scent");
       // butt3.setStyle("-fx-background-color: #ff0000; ");
       // butt3.setAlignment(Pos.TOP_LEFT);
       butt3.setPadding(new Insets(10,60,10,60));
        butt3.setOnAction(e ->{
           window.setScene(scene2);
           //td.showAndWait();// Show pop up window to get inputs
            
        } );
        
        butt2 = new Button("Edit Scent");
       
        butt2.setPadding(new Insets(10,60,10,60));
        butt2.setOnAction(e ->{
            //System.out.println("Hi there button2");
        } );
        
        
        //vbox2.getChildren().add(l);
        vbox.getChildren().addAll(l1,l2,imageInput,l3,l5,l4,button,butt2,butt3);
        
        scene1 = new Scene(vbox, 350, 420);
        primaryStage.setScene(scene1);
        
        butt4 = new Button("Go back");
       // butt3.setStyle("-fx-background-color: #ff0000; ");
       butt4.setPadding(new Insets(10,60,10,60));
        butt4.setOnAction(e ->{
           window.setScene(scene1);
         
           // System.out.println("Hi there");
        } );
        
        //Edit Scene Window Buttons
        Image image1 ;
                image1 = new Image(new FileInputStream(img1));
      ImageView imageInput1 = new ImageView(image1);
      //Setting the position of the image
      imageInput1.setX(1); 
      imageInput1.setY(1); 
      
      imageInput1.setFitHeight(10);
      imageInput1.setFitWidth(10);
        buttW1 = new Button("Scent Info");
        buttW1.setGraphic(new ImageView(image1));
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW1.setPadding(new Insets(10,60,10,60));
        buttW1.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        buttW2 = new Button("Scent Info");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW2.setPadding(new Insets(10,60,10,60));
        buttW2.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        buttW3 = new Button("Scent Info");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW3.setPadding(new Insets(10,60,10,60));
        buttW3.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        buttW4 = new Button("Scent Info");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW4.setPadding(new Insets(10,60,10,60));
        buttW4.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        buttW5 = new Button("Scent Info");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW5.setPadding(new Insets(10,60,10,60));
        buttW5.setOnAction(e ->{
            //System.out.println("Hi there");
        } );
        
        
        
       
        
        
        vbox2.getChildren().addAll(butt4,buttW1,buttW2,buttW3,buttW4,buttW5);
        scene2 = new Scene(vbox2, 350,400);
        
        window.setScene(scene1);
       
        
        window.show();
        
        
    }
    
    public String getDate_Time(){
         DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");  //Can do only time or only date too
    Date date = new Date();  
    //date.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
    System.out.println(formatter.format(date));
    return formatter.format(date);
   //return formatter.format(cal.getTime());
          /*System.out.println("-----Current time of a different time zone using LocalTime-----");
    //ZoneId zoneId = ZoneId.of("America/Fresno");
    LocalTime localTime=LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime=localTime.format(formatter);
    System.out.println("Current time of the day in Los Angeles: " + formattedTime);
    return formattedTime;
          */
    }
    
    public String getScent(String condi){
        String con= "";
        if(condi.equals("Rain")||condi.equals("Drizzle"))
            con= "Cinnamon";
        else if(condi.equals("Clouds"))
            con= "Eucalyptus";
        else if(condi.equals("Clear"))
            con= "Lemon";
        else if(condi.equals("Snow"))
            con= "Spearmint";
        else if(condi.equals("thunderstorm"))
            con= "Spearmint";
        
        return con;
    }
    
   
}
