/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scent;

//Change all images directory to the project direcoty


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
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
/**
 *
 * @author Foklourng
 */
public class SJFX extends Application{
    Button button, butt2,butt3,butt4;
    Button buttW1,buttW2,buttW3,buttW4,buttW5,backB,update,TimerDone;
    String pre_clear ="Lemon", pre_rain="Eucalyptus", pre_cloud="Cinnamon",pre_snow="Spearmint",pre_thunder="Grass";
    String scentN1="Lemon",scentN2="Grass",scentN3="Eucalyptus",scentN4="Cinnamon",scentN5="Spearmint";
    String TimeIn1="",TimeIn2="",TimeIn3="";
    Stage window;
    Scene scene1, scene2,scene3,scene4;
    String[] ScSet = new String[]{"Lemon","Eucalyptus","Cinnamon","Spearmint","Grass"};//All available scent or user prefer scents
   // String[] scAll= new String[]{"Lemon","Eucalyptus","Cinnamon","Spearmint","Grass"};
    SCENT obj1 = new SCENT();
    
    ChoiceBox<String> choicebox1 = new ChoiceBox<>();
    ChoiceBox<String> choicebox2 = new ChoiceBox<>();
    ChoiceBox<String> choicebox3 = new ChoiceBox<>();
    ChoiceBox<String> choicebox4 = new ChoiceBox<>();
    ChoiceBox<String> choicebox5 = new ChoiceBox<>();
     
    
    Label l5;
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        launch(args);
        //assertEquals
     JunitTesting test = new JunitTesting();
     int output = test.square(5);
     assertEquals(25, output);
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
        l5 = new Label("Recommended Scent: " + getScent(obj1.WT));
        
        String img1,img2,img3,img4,img5;
        
        img1 = "C:\\Users\\muy heng\\Documents\\NetBeansProjects\\Scent\\Images\\cloudy.png";
        img2 = "C:\\Users\\muy heng\\Documents\\NetBeansProjects\\Scent\\Images\\sunny.png";
        img3 = "C:\\Users\\muy heng\\Documents\\NetBeansProjects\\Scent\\Images\\rainy.png";
        img4 = "C:\\Users\\muy heng\\Documents\\NetBeansProjects\\Scent\\Images\\snowy.png";
        img5 = "C:\\Users\\muy heng\\Documents\\NetBeansProjects\\Scent\\Images\\thunder.png";
        
        
        
        //User Input
       // TextInputDialog td = new TextInputDialog("Enter Event");
        
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
           image = new Image(new FileInputStream(img2));

        
             
     
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
        
        button = new Button("Edit Release Time");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        button.setPadding(new Insets(10,60,10,60));
        button.setOnAction(e ->{
            //System.out.println("Hi there");
            window.setScene(scene4);
        } );
        
        butt3 = new Button("Edit Scent");
       // butt3.setStyle("-fx-background-color: #ff0000; ");
       // butt3.setAlignment(Pos.TOP_LEFT);
       butt3.setPadding(new Insets(10,60,10,60));
        butt3.setOnAction(e ->{
            //UpdateScentSet();
           window.setScene(scene2);
           //td.showAndWait();// Show pop up window to get inputs
            
        } );
        
        butt2 = new Button("Add Scent");
       
        butt2.setPadding(new Insets(10,60,10,60));
        butt2.setOnAction(e ->{
            window.setScene(scene3);
            //System.out.println("Hi there button2");
        } );
        
        
        //vbox2.getChildren().add(l);
        vbox.getChildren().addAll(l1,l2,imageInput,l3,l5,l4,button,butt2,butt3);
        
        scene1 = new Scene(vbox, 350, 420);
        primaryStage.setScene(scene1);
        
        
        //Edit Scene Window Buttons
        Image image1 ;
                image1 = new Image(new FileInputStream(img1));
      ImageView imageInput1 = new ImageView(image1);
      //Setting the position of the image
      imageInput1.setX(1); 
      imageInput1.setY(1); 
      
      imageInput1.setFitHeight(10);
      imageInput1.setFitWidth(10);
      
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setVgap(10);
      grid.setHgap(10);
      grid.setPadding(new Insets(10));
      
        
      
      //ChoiceBox<String> choicebox1 = new ChoiceBox<>();
      choicebox1.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox1.setValue(ScSet[0]);
      
      //ChoiceBox<String> choicebox2 = new ChoiceBox<>();
      choicebox2.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox2.setValue(ScSet[1]);
      
      //ChoiceBox<String> choicebox3 = new ChoiceBox<>();
      choicebox3.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox3.setValue(ScSet[2]);
      
      //ChoiceBox<String> choicebox4 = new ChoiceBox<>();
      choicebox4.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox4.setValue(ScSet[3]);
      
      //ChoiceBox<String> choicebox5 = new ChoiceBox<>();
      choicebox5.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox5.setValue(ScSet[4]);
      
        buttW1 = new Button("Clear");
        //buttW1.setGraphic(new ImageView(image1));
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW1.setPadding(new Insets(10,40,10,40));
        buttW1.setOnAction(e ->{
             
        } );
        buttW2 = new Button("Rainy");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW2.setPadding(new Insets(10,40,10,40));
        buttW2.setOnAction(e ->{
           
        } );
        buttW3 = new Button("Cloudy");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW3.setPadding(new Insets(10,40,10,40));
        buttW3.setOnAction(e ->{
             
        } );
        buttW4 = new Button("Snow");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW4.setPadding(new Insets(10,40,10,40));
        buttW4.setOnAction(e ->{
             
        } );
        buttW5 = new Button("Thunderstorm");
        //button.setStyle("-fx-background-color: #ff0000; ");
        
        buttW5.setPadding(new Insets(10,40,10,40));
        buttW5.setOnAction(e ->{
            
        } );
        
        //Finish Editing Scent
        backB = new Button("Done");
        backB.setPadding(new Insets(10,40,10,40));
        backB.setOnAction(e ->{
            
            pre_clear = choicebox1.getValue();
            pre_rain = choicebox2.getValue();
            pre_cloud = choicebox3.getValue();
            pre_snow = choicebox4.getValue();
            pre_thunder = choicebox5.getValue();
            UpdateScentRecom();
           window.setScene(scene1);
         
           System.out.println(pre_clear + " ," + pre_rain + " ," + pre_cloud + " ," + pre_snow + " ,"  + pre_thunder);
        } );
        
        grid.add(buttW1, 0, 0);
        grid.add(buttW2, 0, 1);
        grid.add(buttW3, 0, 2);
        grid.add(buttW4, 0, 3);
        grid.add(buttW5, 0, 4);
        grid.add(backB, 1,5);
        grid.add(choicebox1,1,0);
        grid.add(choicebox2,1,1);
        grid.add(choicebox3,1,2);
        grid.add(choicebox4,1,3);
        grid.add(choicebox5,1,4);
        
        
        scene2 = new Scene(grid, 350,400);
        
        //Scene3
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setVgap(10);
        grid3.setHgap(10);
        grid3.setPadding(new Insets(10));

        Label Sl1 = new Label("SCENT 1"); //Scent lable
        Label Sl2 = new Label("SCENT 2" ); 
        Label Sl3 = new Label("SCENT 3"); 
        Label Sl4 = new Label("SCENT 4"); 
        Label Sl5 = new Label("SCENT 5");

        ChoiceBox<String> scent1 = new ChoiceBox<>();
        scent1.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Grass","Ham","Apple","Pineapple","Coffe","Chocolate");
        scent1.setValue(ScSet[0]);

        ChoiceBox<String> scent2 = new ChoiceBox<>();
        scent2.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Grass","Ham","Apple","Pineapple","Coffe","Chocolate");
        scent2.setValue(ScSet[1]);

        ChoiceBox<String> scent3 = new ChoiceBox<>();
        scent3.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Grass","Ham","Apple","Pineapple","Coffe","Chocolate");
        scent3.setValue(ScSet[2]);

        ChoiceBox<String> scent4 = new ChoiceBox<>();
        scent4.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Grass","Ham","Apple","Pineapple","Coffe","Chocolate");
        scent4.setValue(ScSet[3]);

        ChoiceBox<String> scent5 = new ChoiceBox<>();
        scent5.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Grass","Ham","Apple","Pineapple","Coffe","Chocolate");
        scent5.setValue(ScSet[4]);
        
        
        update = new Button("Update");
        update.setPadding(new Insets(10,40,10,40));
        update.setOnAction(e ->{
            ScSet[0] = scent1.getValue();
            ScSet[1] = scent2.getValue();
            ScSet[2] = scent3.getValue();
            ScSet[3] = scent4.getValue();
            ScSet[4] = scent5.getValue();
            
            UpdateScentSet();
           window.setScene(scene1);
         
           System.out.println(ScSet[0] + " " + ScSet[1] + " " + ScSet[2] + " " + ScSet[3] + " "  + ScSet[4]);
        } );
        
        grid3.add(Sl1, 0, 0);
        grid3.add(Sl2, 0, 1);
        grid3.add(Sl3, 0, 2);
        grid3.add(Sl4, 0, 3);
        grid3.add(Sl5, 0, 4);
        grid3.add(update, 1,5);
        grid3.add(scent1,1,0);
        grid3.add(scent2,1,1);
        grid3.add(scent3,1,2);
        grid3.add(scent4,1,3);
        grid3.add(scent5,1,4);
        
        scene3 = new Scene(grid3, 350,400);
        
        
        //Scene4
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setVgap(10);
        grid4.setHgap(10);
        grid4.setPadding(new Insets(10));

        Label T1 = new Label("Timer 1"); //Scent lable
        Label T2 = new Label("Timer 2" ); 
        Label T3 = new Label("Timer 3"); 

        ChoiceBox<String> Tr1 = new ChoiceBox<>();
        Tr1.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        Tr1.setValue("6:00 am");

        ChoiceBox<String> Tr2 = new ChoiceBox<>();
        Tr2.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        Tr2.setValue("12:00 pm");

        ChoiceBox<String> Tr3 = new ChoiceBox<>();
        Tr3.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        Tr3.setValue("6:00 pm");

        
        
        TimerDone = new Button("Update");
        TimerDone.setPadding(new Insets(10,40,10,40));
        TimerDone.setOnAction(e ->{
            TimeIn1 = Tr1.getValue();
            TimeIn2 = Tr2.getValue();
            TimeIn3 = Tr3.getValue();
           window.setScene(scene1);
         
           System.out.println(TimeIn1 + " " + TimeIn2 + " " + TimeIn3);
        } );
        
        grid4.add(T1, 0, 0);
        grid4.add(T2, 0, 1);
        grid4.add(T3, 0, 2);
        grid4.add(TimerDone, 1,3);
        grid4.add(Tr1,1,0);
        grid4.add(Tr2,1,1);
        grid4.add(Tr3,1,2);
        
        scene4 = new Scene(grid4, 350,400);
        
        
        window.setScene(scene1);
       
        
        window.show();
        
        
    }
    
    public String getDate_Time(){
         DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");  //Can do only time or only date too
    Date date = new Date();  
    //date.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
    System.out.println(formatter.format(date));
    return formatter.format(date);
    }
    
    public String getScent(String condi){
        String con= "";
        if(condi.equals("Clear"))
            con= pre_clear;
        else if(condi.equals("Rain")||condi.equals("Drizzle"))
            con= pre_rain;
        else if(condi.equals("Clouds"))
            con= pre_cloud;
        
        else if(condi.equals("Snow"))
            con= pre_snow;
        else if(condi.equals("thunderstorm"))
            con= pre_thunder;
        
        return con;
    }
    
    public void UpdateScentRecom(){
        l5.setText("Recommended Scent: " + getScent(obj1.WT));
    }
    
    public void UpdateScentSet(){
        System.out.println(ScSet[0] + " + " + ScSet[1] + " + " + ScSet[2] + " + " + ScSet[3] + " + " + ScSet[4]);
        
        //choicebox1 = new ChoiceBox(FXCollections.observableArrayList(ScSet));
        //choicebox1.setValue(ScSet[0]);
        choicebox1.getItems().clear();
      choicebox1.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
     
      
      //choicebox2 = new ChoiceBox<>();
      choicebox2.getItems().clear();
      choicebox2.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      //choicebox2.setValue(ScSet[1]);
      
      //choicebox3 = new ChoiceBox<>();
      choicebox3.getItems().clear();
      choicebox3.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      //choicebox3.setValue(ScSet[2]);
      
     // choicebox4 = new ChoiceBox<>();
     choicebox4.getItems().clear();
      choicebox4.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
     // choicebox4.setValue(ScSet[3]);
      
      //choicebox5 = new ChoiceBox<>();
      choicebox5.getItems().clear();
      choicebox5.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      //choicebox5.setValue(ScSet[4]);
       
    }
    
   
}
