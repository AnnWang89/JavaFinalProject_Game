package ce1002.f1.s107502509.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ce1002.f1.s107502509.finalproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ScenethreeLockController extends finalproject implements Initializable{
	@FXML
	Label _time;
	@FXML
	Pane _one;
	@FXML
	Pane _two;
	@FXML
	Pane _three;
	@FXML
	Pane _four;
	@FXML
	Pane _five;
	@FXML
	Pane _six;
	@FXML
	Pane _seven;
	@FXML
	Pane _eight;
	@FXML
	Pane _nine;
	@FXML
	Pane _zero;
	@FXML
	Label _wrong;
	/*
	 * variable
	 */
	int codenumber = 0;
	
	/*
	 * time
	 */
	public static String  line;
	public void initialize(URL arg0, ResourceBundle arg1) { 
		_time.setText( "Time      " + String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second));
		MainController.fps = new Timeline(
				new KeyFrame(Duration.millis(1000), (e) -> {
				
		   if (MainController.minute == 0 && MainController.second == 0) {
			   /*
			   line=MainController.Name+" Game over..... ";
			   out.println(line);
		       out.flush();
		       */
			   FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/gameover.fxml"));
			   Parent over = null;
			   try {
				   over = loadder.load();
			   } catch (IOException e1) {
				    //TODO Auto-generated catch block
				   e1.printStackTrace();
			   }
			   Scene overScene = new Scene(over);    
			   finalproject.mainStage.setScene(overScene);
		   }
		   if (MainController.second < 0) {
			   MainController.second = 59;
			   MainController.minute--;
		   }
		   _time.setText( "Time      " + String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second));
		  }));//set the new time
		MainController.fps.setCycleCount(Timeline.INDEFINITE);//will keep reset 
		  MainController.fps.play();
		
	}
	public void OnBackPressed(ActionEvent e) throws IOException {//back to scene3
	    finalproject.mainStage.setScene(ScenetwoController2.thirdScene);
	}
	/*
	 * number
	 */
	public void One(MouseEvent e) {
		codenumber = codenumber*10 + 1;
		System.out.println(codenumber);
	}
	public void Two(MouseEvent e) {
		codenumber = codenumber*10 + 2;
		System.out.println(codenumber);
	}
	public void Three(MouseEvent e) {
		codenumber = codenumber*10 + 3;
		System.out.println(codenumber);
	}
	public void Four(MouseEvent e) {
		codenumber = codenumber*10 + 4;
		System.out.println(codenumber);
	}
	public void Five(MouseEvent e) {
		codenumber = codenumber*10 + 5;
		System.out.println(codenumber);
	}
	public void Six(MouseEvent e) {
		codenumber = codenumber*10 + 6;
		System.out.println(codenumber);
	}
	public void Seven(MouseEvent e) {
		codenumber = codenumber*10 + 7;
		System.out.println(codenumber);
	}
	public void Eight(MouseEvent e) {
		codenumber = codenumber*10 + 8;
		System.out.println(codenumber);
	}
	public void Nine(MouseEvent e) {
		codenumber = codenumber*10 + 9;
		System.out.println(codenumber);
	}
	public void Zero(MouseEvent e) {
		codenumber = codenumber*10 ;
		System.out.println(codenumber);
	}
	public void Enter(MouseEvent e) {
		if(codenumber == 5472) {
			ScenethreeController.code = true;
			finalproject.mainStage.setScene(ScenetwoController2.thirdScene);
			_wrong.setVisible(false);
			System.out.println(codenumber);
		}
		else {
			_wrong.setVisible(true);
			codenumber = 0;
			System.out.println(codenumber);
		}
			
	}

}
