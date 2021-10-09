package ce1002.f1.s107502509.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class VaseController extends finalproject implements Initializable{
	@FXML
	Label _time;
	@FXML
	Label _wrong;
	@FXML
	ImageView _vasewhole;
	@FXML
	ImageView _vasepiece1;
	@FXML
	ImageView _vasepiece2;
	@FXML
	ImageView _vasepiece3;
	@FXML
	ImageView _vasepiece4;
	@FXML
	ImageView _vasepiece5;
	@FXML
	ImageView _vasepiece6;
	@FXML
	ImageView _vasepiece7;
	@FXML
	ImageView _vasepiece8;
	@FXML
	ImageView _vasepiece9;
	@FXML
	ImageView _vasepiece10;
	public static String  line;
	public void initialize(URL arg0, ResourceBundle arg1) { 
		_time.setText( "Time      " + String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second));
		MainController.fps = new Timeline(
				new KeyFrame(Duration.millis(1000), (e) -> {
				
		   if (MainController.minute == 0 && MainController.second == 0) {
			   /*
			   line=" Game over..... ";
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
	public void DragPiece1(MouseEvent e) {
		_vasepiece1.setX(e.getX()-45);
		_vasepiece1.setY(e.getY()-140);
	}
	public void DragPiece2(MouseEvent e) {
		_vasepiece2.setX(e.getX()-45);
		_vasepiece2.setY(e.getY()-30);
	}
	public void DragPiece3(MouseEvent e) {
		_vasepiece3.setX(e.getX()-50);
		_vasepiece3.setY(e.getY()-25);
	}
	public void DragPiece4(MouseEvent e) {
		_vasepiece4.setX(e.getX()-40);
		_vasepiece4.setY(e.getY()-70);
	}
	public void DragPiece5(MouseEvent e) {
		_vasepiece5.setX(e.getX()-65);
		_vasepiece5.setY(e.getY()-55);
	}
	public void DragPiece6(MouseEvent e) {
		_vasepiece6.setX(e.getX()-30);
		_vasepiece6.setY(e.getY()-105);
	}
	public void DragPiece7(MouseEvent e) {
		_vasepiece7.setX(e.getX()-75);
		_vasepiece7.setY(e.getY()-105);
	}
	public void DragPiece8(MouseEvent e) {
		_vasepiece8.setX(e.getX()-45);
		_vasepiece8.setY(e.getY()-130);
	}
	public void DragPiece9(MouseEvent e) {
		_vasepiece9.setX(e.getX()-60);
		_vasepiece9.setY(e.getY()-85);
	}
	public void DragPiece10(MouseEvent e) {
		_vasepiece10.setX(e.getX()-50);
		_vasepiece10.setY(e.getY()-165);
	}
	public void PutPiece1(MouseEvent e)	{
		if(_vasepiece1.getX() >= -185 && _vasepiece1.getX() <= -165 &&_vasepiece1.getY() <= 100 &&_vasepiece1.getY() >= 80) {
			_vasepiece1.setX(-177);
			_vasepiece1.setY(90);
		}
	}
	public void PutPiece2(MouseEvent e)	{
		if(_vasepiece2.getX() >= -125 && _vasepiece2.getX() <= -105 &&_vasepiece2.getY() <= -115 &&_vasepiece2.getY() >= -135) {
			_vasepiece2.setX(-116);
			_vasepiece2.setY(-124);
		}
	}
	public void PutPiece3(MouseEvent e)	{
		if(_vasepiece3.getX() >= 110 && _vasepiece3.getX() <= 130 &&_vasepiece3.getY() <= -90 &&_vasepiece3.getY() >= -110) {
			_vasepiece3.setX(118);
			_vasepiece3.setY(-100);
		}
	}
	public void PutPiece4(MouseEvent e)	{
		if(_vasepiece4.getX() >= -80 && _vasepiece4.getX() <= -60 &&_vasepiece4.getY() <= -125 &&_vasepiece4.getY() >= -145) {
			_vasepiece4.setX(-71);
			_vasepiece4.setY(-136);
		}
	}
	public void PutPiece5(MouseEvent e)	{
		if(_vasepiece5.getX() >= -150 && _vasepiece5.getX() <= -130 &&_vasepiece5.getY() <= -155 &&_vasepiece5.getY() >= -175) {
			_vasepiece5.setX(-141);
			_vasepiece5.setY(-166);
		}
	}
	public void PutPiece6(MouseEvent e)	{
		if(_vasepiece6.getX() >= -125 &&
		   _vasepiece6.getX() <= -105 &&
		   _vasepiece6.getY() <= 130 &&
		   _vasepiece6.getY() >= 110) {
			_vasepiece6.setX(-116);
			_vasepiece6.setY(118);
		}
	}
	public void PutPiece7(MouseEvent e)	{
		if(_vasepiece7.getX() >= 190 &&
		   _vasepiece7.getX() <= 210 &&
		   _vasepiece7.getY() <= -55 &&
		   _vasepiece7.getY() >= -75) {
			_vasepiece7.setX(199);
			_vasepiece7.setY(-66);
		}
	}
	public void PutPiece8(MouseEvent e)	{
		if(_vasepiece8.getX() >= 110 &&
		   _vasepiece8.getX() <= 130 &&
		   _vasepiece8.getY() <= -100 &&
		   _vasepiece8.getY() >= -120) {
			_vasepiece8.setX(122);
			_vasepiece8.setY(-110);
		}
	}
	public void PutPiece9(MouseEvent e)	{
		if(_vasepiece9.getX() >= 110 &&
				   _vasepiece9.getX() <= 130 &&
				   _vasepiece9.getY() <= 130 &&
				   _vasepiece9.getY() >= 110) {
					_vasepiece9.setX(122);
					_vasepiece9.setY(118);
				}
	}
	public void PutPiece10(MouseEvent e)	{
		if(_vasepiece10.getX() >= -150 &&
		   _vasepiece10.getX() <= -130 &&
		   _vasepiece10.getY() <= 230 &&
		   _vasepiece10.getY() >= 210) {
			_vasepiece10.setX(-141);
			_vasepiece10.setY(218);
		}
	}
	public void Finish(ActionEvent e) {
		if( _vasepiece1.getX() == -177 && _vasepiece1.getY() == 90 &&
			_vasepiece2.getX() == -116 && _vasepiece2.getY() == -124 &&
			_vasepiece3.getX() == 118 && _vasepiece3.getY() == -100 &&
			_vasepiece4.getX() == -71 && _vasepiece4.getY() == -136 &&
			_vasepiece5.getX() == -141 && _vasepiece5.getY() == -166 &&
			_vasepiece6.getX() == -116 && _vasepiece6.getY() == 118 &&
			_vasepiece7.getX() == 199 && _vasepiece7.getY() == -66 &&
			_vasepiece8.getX() == 122 && _vasepiece8.getY() == -110 &&
			_vasepiece9.getX() == 122 && _vasepiece9.getY() == 118 &&
			_vasepiece10.getX() == -141 && _vasepiece10.getY() == 218) {
			finalproject.mainStage.setScene(SceneoneController.secondScene);
		}else {
			_wrong.setVisible(true);
		}
	}

}
