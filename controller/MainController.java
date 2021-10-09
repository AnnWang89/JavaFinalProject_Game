package ce1002.f1.s107502509.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import ce1002.f1.s107502509.finalproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class MainController implements Initializable{
	public static int minute = 10; 
	public static int second = 0; 
	public static String Name;
	public static Timeline fps;
	public String timestring ;
	public static Scene firstScene;
	
	@FXML
	Label _time;
	@FXML
	Label _rank;
	@FXML
	TextField _name;
	public void initialize(URL arg0, ResourceBundle arg1) { 
		MainController.fps = new Timeline(
				new KeyFrame(Duration.millis(1000), (e) -> {
					MainController.second--;
				
		   
		   if (MainController.second < 0) {
			   MainController.second = 59;
			   MainController.minute--;
		   }
		   
		  // System.out.println(MainController.second);
		   _time.setText( "Time      " + String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second));
		  }));//set the new time
		try {
			FileInputStream fis = new FileInputStream("file/rank.txt");
			byte[] allByte = fis.readAllBytes();
			String content = new String(allByte, "UTF-8");
			_rank.setText(content);
			

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		  MainController.fps.setCycleCount(Timeline.INDEFINITE);//will keep reset 
		  MainController.fps.play();
	}

	public void OnStartPressed(ActionEvent e) throws IOException {
		Name=_name.getText();
	    minute = 10; 
		second = 1; 
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/sceneone.fxml"));
	    Parent first = loadder.load();
	    firstScene = new Scene(first);
	    SceneoneController oneCtrl = loadder.getController();
	    firstScene.setOnKeyPressed(oneCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(firstScene);
	}
	public void OnExitPressed(ActionEvent e) {
		finalproject.mainStage.close();
	}
	public void OnHelpPressed(ActionEvent e) throws IOException {
	    FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/help.fxml"));
	    Parent help = loadder.load();
	    Scene helpScene = new Scene(help);
	    finalproject.mainStage.setScene(helpScene);
	}
	public void OnStoryPressed(ActionEvent e) throws IOException {
	    FXMLLoader load = new FXMLLoader(getClass().getResource("../views/story2.fxml"));
	    Parent story = load.load();
	    Scene storyScene = new Scene(story);
	    finalproject.mainStage.setScene(storyScene);
	}

}
