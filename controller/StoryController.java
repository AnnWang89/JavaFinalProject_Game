package ce1002.f1.s107502509.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ce1002.f1.s107502509.finalproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class StoryController implements Initializable{
	@FXML
	Label _line1;
	@FXML
	Label _line2;
	@FXML
	Label _line3;
	@FXML
	Label _line4;
	@FXML
	Label _line5;
	@FXML
	Label _line6;
	@FXML
	ImageView _witch;
	@FXML
	ImageView _penguin;
	
	int number = 0;
	Timeline line ;
	public void initialize(URL arg0, ResourceBundle arg1) { 
		line = new Timeline(
				new KeyFrame(Duration.millis(700), (e) -> {
					number++;
				if(number == 1) {
					_line1.setVisible(true);
				}
				if(number == 2) {
					_line2.setVisible(true);
				}
				if(number == 3) {
					_line3.setVisible(true);
				}
				if(number == 4) {
					_line4.setVisible(true);
				}
				if(number == 5) {
					_line5.setVisible(true);
				}
				if(number == 6) {
					_line6.setVisible(true);
				}
				if(number == 7) {
					_witch.setVisible(true);
				}
				if(number == 8) {
					_penguin.setVisible(true);
				}
		  }));//set the new time
			line.setCycleCount(Timeline.INDEFINITE);//will keep reset 
			line.play();
	}

	public void OnBackPressed(MouseEvent e) {
		line.stop();
	    finalproject.mainStage.setScene(finalproject.mainScene);
	}
	
}
