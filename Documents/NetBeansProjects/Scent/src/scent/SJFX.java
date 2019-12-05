/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scent;

//Change all images directory to the project direcoty


import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;        
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView; 
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import static org.junit.Assert.assertEquals;
/**
 *
 * @author Foklourng
 */
public class SJFX extends Application{
    
    //initializations
    Button editTimeButt, addScentButt,editScentButt,butt4;
    Button backB,update,TimerDone;
    //preset inputs
    String pre_clear ="Lemon", pre_rain="Eucalyptus", pre_cloud="Cinnamon",pre_snow="Spearmint",pre_thunder="Peppermint";
    String scentN1="Lemon",scentN2="Peppermint",scentN3="Eucalyptus",scentN4="Cinnamon",scentN5="Spearmint";
    String TimeIn1="",TimeIn2="",TimeIn3="";
    Stage window;
    Scene scene1, scene2,scene3,scene4;
    String[] ScSet = new String[]{"Lemon","Eucalyptus","Cinnamon","Spearmint","Peppermint"};//All available scent or user prefer scents
   
    SCENT obj1 = new SCENT();
    Label recScent;
    
    ChoiceBox<String> choicebox1 = new ChoiceBox<>();
    ChoiceBox<String> choicebox2 = new ChoiceBox<>();
    ChoiceBox<String> choicebox3 = new ChoiceBox<>();
    ChoiceBox<String> choicebox4 = new ChoiceBox<>();
    ChoiceBox<String> choicebox5 = new ChoiceBox<>();
     
    
    
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
        
        
        //run weather function
        obj1.weather();
        //Labels on Main scene
        Label title = new Label("SCENT STRATOSPHERE"); 
        Label currWeather = new Label("Current Weather in "+ obj1.city + " , " + obj1.country ); 
        Label weatherDisplay = new Label(obj1.WTD + " Temp: " + obj1.temp + " F"); 
        Label time = new Label(getDate_Time()); 
        Label recScent = new Label("Recommended Scent: " + getScent(obj1.WT));
        
        //Images for the scene
        String img1,img2,img3,img4,img5;
        
        img1 = "C:\\Users\\mkroe\\Documents\\NetBeansProjects\\Scent\\Images\\cloudy.png";
        img2 = "C:\\Users\\mkroe\\Documents\\NetBeansProjects\\Scent\\Images\\sunny.png";
        img3 = "C:\\Users\\mkroe\\Documents\\NetBeansProjects\\Scent\\Images\\rainy.png";
        img4 = "C:\\Users\\mkroe\\Documents\\NetBeansProjects\\Scent\\Images\\snowy.png";
        img5 = "C:\\Users\\mkroe\\Documents\\NetBeansProjects\\Scent\\Images\\thunder.png";
        
 
  
        
       //Weather condition image checker, program displays image that corresponds with weather type
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
       
        //used for main page
        VBox vbox= new VBox(12);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setPadding(new Insets(20,10,20,10));
        
        //when editTimeButt is clicked...
        editTimeButt = new Button("Edit Release Time");
        
        editTimeButt.setPadding(new Insets(10,60,10,60));
        editTimeButt.setOnAction(e ->{
            
            window.setScene(scene4);
            
        } );
        
        //when the editScentButt is clicked...
        editScentButt = new Button("Edit Scent");
       editScentButt.setPadding(new Insets(10,60,10,60));
        editScentButt.setOnAction(e ->{
          
           window.setScene(scene2);
            
        } );
        
        //when addScentButt is clicked...
        addScentButt = new Button("Add Scent");
       
        addScentButt.setPadding(new Insets(10,60,10,60));
        addScentButt.setOnAction(e ->{
            
            window.setScene(scene3);
            
        } );
        
        
        //adding all the main page features to the vbox
        vbox.getChildren().addAll(title,currWeather,imageInput,weatherDisplay,recScent,time,editTimeButt,addScentButt,editScentButt);
       
        //setting up the main page
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
      
        
      
      //INSIDE THE EDIT SCENT BUTTON-------------------------------------------------
      choicebox1.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox1.setValue(ScSet[0]);
      
      
      choicebox2.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox2.setValue(ScSet[1]);
      
     
      choicebox3.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox3.setValue(ScSet[2]);
      
      
      choicebox4.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox4.setValue(ScSet[3]);
      
    
      choicebox5.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      choicebox5.setValue(ScSet[4]);
      
      Label labelW1, labelW2, labelW3, labelW4, labelW5;
        labelW1 = new Label("Clear");
        labelW1.setPadding(new Insets(10,40,10,40));
        
        labelW2 = new Label("Rainy");
        labelW2.setPadding(new Insets(10,40,10,40));
       
        labelW3 = new Label("Cloudy");
        labelW3.setPadding(new Insets(10,40,10,40));
        
        labelW4 = new Label("Snow");
        labelW4.setPadding(new Insets(10,40,10,40));
        
        labelW5 = new Label("Thunderstorm");
        labelW5.setPadding(new Insets(10,40,10,40));
        
        
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
        //SETTING THE EDIT SCENT SCENE
        grid.add(labelW1, 0, 0);
        grid.add(labelW2, 0, 1);
        grid.add(labelW3, 0, 2);
        grid.add(labelW4, 0, 3);
        grid.add(labelW5, 0, 4);
        grid.add(backB, 1,5);
        grid.add(choicebox1,1,0);
        grid.add(choicebox2,1,1);
        grid.add(choicebox3,1,2);
        grid.add(choicebox4,1,3);
        grid.add(choicebox5,1,4);
        
        scene2 = new Scene(grid, 350,400);
        //END OF EDIT SCENT---------------------
        
        
        //INTO ADD SCENT BUTTON----------------------
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setVgap(10);
        grid3.setHgap(10);
        grid3.setPadding(new Insets(10));

        //labels for the scent options
        Label sLabel1 = new Label("SCENT 1"); 
        Label sLabel2 = new Label("SCENT 2" ); 
        Label sLabel3 = new Label("SCENT 3"); 
        Label sLabel4 = new Label("SCENT 4"); 
        Label sLabel5 = new Label("SCENT 5");
        
        //all the drop down menus
        ChoiceBox<String> scent1 = new ChoiceBox<>();
        scent1.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Frankincense","Peppermint","Vanilla","Rose","Coffee","Thyme");
        scent1.setValue(ScSet[0]);

        ChoiceBox<String> scent2 = new ChoiceBox<>();
        scent2.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Frankincense","Peppermint","Vanilla","Rose","Coffee","Thyme");
        scent2.setValue(ScSet[1]);

        ChoiceBox<String> scent3 = new ChoiceBox<>();
        scent3.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Frankincense","Peppermint","Vanilla","Rose","Coffee","Thyme");
        scent3.setValue(ScSet[2]);

        ChoiceBox<String> scent4 = new ChoiceBox<>();
        scent4.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Frankincense","Peppermint","Vanilla","Rose","Coffee","Thyme");
        scent4.setValue(ScSet[3]);

        ChoiceBox<String> scent5 = new ChoiceBox<>();
        scent5.getItems().addAll("Lemon","Eucalyptus","Cinnamon","Spearmint","Frankincense","Peppermint","Vanilla","Rose","Coffee","Thyme");
        scent5.setValue(ScSet[4]);
        
        //update button
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
        
        grid3.add(sLabel1, 0, 0);
        grid3.add(sLabel2, 0, 1);
        grid3.add(sLabel3, 0, 2);
        grid3.add(sLabel4, 0, 3);
        grid3.add(sLabel5, 0, 4);
        grid3.add(update, 1,5);
        grid3.add(scent1,1,0);
        grid3.add(scent2,1,1);
        grid3.add(scent3,1,2);
        grid3.add(scent4,1,3);
        grid3.add(scent5,1,4);
        
        scene3 = new Scene(grid3, 350,400);
        //END OF ADD SCENT BUTTON------------------------------------------------
        
        //EDIT TIME BUTTON-------------------------------------------------------
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setVgap(10);
        grid4.setHgap(10);
        grid4.setPadding(new Insets(10));

        Label time1 = new Label("Timer 1"); //Scent lable
        Label time2 = new Label("Timer 2" ); 
        Label time3 = new Label("Timer 3"); 

        ChoiceBox<String> timeset1 = new ChoiceBox<>();
        timeset1.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        timeset1.setValue("6:00 am");

        ChoiceBox<String> timeset2 = new ChoiceBox<>();
        timeset2.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        timeset2.setValue("12:00 pm");

        ChoiceBox<String> timeset3 = new ChoiceBox<>();
        timeset3.getItems().addAll("6:00 am","8:00 am","10:00 am","12:00 pm","2:00 pm","4:00 pm.","6:00 pm","8:00 pm","10:00 pm");
        timeset3.setValue("6:00 pm");

        
        
        TimerDone = new Button("Update");
        TimerDone.setPadding(new Insets(10,40,10,40));
        TimerDone.setOnAction(e ->{
            TimeIn1 = timeset1.getValue();
            TimeIn2 = timeset2.getValue();
            TimeIn3 = timeset3.getValue();
           window.setScene(scene1);
         
           System.out.println(TimeIn1 + " " + TimeIn2 + " " + TimeIn3);
        } );
        
        grid4.add(time1, 0, 0);
        grid4.add(time2, 0, 1);
        grid4.add(time3, 0, 2);
        grid4.add(TimerDone, 1,3);
        grid4.add(timeset1,1,0);
        grid4.add(timeset2,1,1);
        grid4.add(timeset3,1,2);
        
        scene4 = new Scene(grid4, 350,400);
        
        
        window.setScene(scene1);
       
        
        window.show();
        
        
    }
    
    //time formater
    public String getDate_Time(){
         DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");  //Can do only time or only date too
    Date date = new Date();  
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
        recScent.setText("Recommended Scent: " + getScent(obj1.WT));
    }
    
    public void UpdateScentSet(){
        System.out.println(ScSet[0] + " + " + ScSet[1] + " + " + ScSet[2] + " + " + ScSet[3] + " + " + ScSet[4]);
       
        choicebox1.getItems().clear();
      choicebox1.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
     
      
      
      choicebox2.getItems().clear();
      choicebox2.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
     
      
      
      choicebox3.getItems().clear();
      choicebox3.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      
      
     
     choicebox4.getItems().clear();
      choicebox4.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
     

      choicebox5.getItems().clear();
      choicebox5.getItems().addAll(ScSet[0],ScSet[1],ScSet[2],ScSet[3],ScSet[4]);
      
       
    }
    
   
}
