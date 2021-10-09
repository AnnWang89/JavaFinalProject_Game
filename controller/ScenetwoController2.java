package ce1002.f1.s107502509.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import ce1002.f1.s107502509.finalproject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class ScenetwoController2 extends finalproject implements Initializable{
	@FXML
	Label _time;
	@FXML
	ImageView _penguinright;
	@FXML
	ImageView _penguinleft;
	@FXML
	ImageView _penguinback;
	@FXML
	ImageView _penguinfront;
	@FXML
	ImageView _penguinfall;
	@FXML
	ImageView _penguinfly;
	@FXML
	ImageView _cannonin;
	@FXML
	ImageView _cannonout2;
	@FXML
	ImageView _cannonout;
	@FXML
	ImageView _keyboxin;
	@FXML
	ImageView _keyboxout;
	@FXML
	ImageView _keyin;
	@FXML
	ImageView _keyout;
	@FXML
	ImageView _boxclose;
	@FXML
	ImageView _boxopen;
	@FXML
	Group _doortwoopen;
	@FXML
	ImageView _water;
	
	
	/*
	 * variable
	 */
	public static Scene thirdScene;
	boolean dooropen = false;
	boolean firsttime = true;
	boolean boxopen = false;
	boolean cannonplace = false;
	boolean flyfly = false;
	Timeline fly;
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
	public void animation () {
		fly = new Timeline(new KeyFrame(Duration.millis(1000/25),(e)-> {
			_penguinfly.setX(_penguinfly.getX()+5);
			if(_penguinfly.getX() < 100)
				_penguinfly.setY(_penguinfly.getY()-5);
			else
				_penguinfly.setY(_penguinfly.getY()+5);
			if(_penguinfly.getX() > 210 &&  cannonplace && flyfly) {
			     _penguinfly.setVisible(false);
			     _penguinright.setVisible(true);
			     _water.setVisible(false);	     
			     flyfly = false;
			 }
		 }));
		  fly.setCycleCount(Timeline.INDEFINITE);
		  fly.play();
	}
	/*
	public void ClicktheDoor(MouseEvent e) throws IOException {//click the door to the next scene
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenethree.fxml"));
	    Parent third = loadder.load();
	    thirdScene = new Scene(third);
	    ScenethreeController thirdCtrl = loadder.getController();
	    thirdScene.setOnKeyPressed(thirdCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(thirdScene);
	}
	*/
	/*
	 * collect thing
	 */
	public void CollectCannon(MouseEvent e) {
		_cannonout.setVisible(false);
		_cannonin.setVisible(true);
	}
	public void CollectKey(MouseEvent e) {//put the key in the box
		_keyin.setVisible(true);
		_keyout.setVisible(false);
	}
	public void CollectBoxkey(MouseEvent e) {//put the key in the box
		_keyboxin.setVisible(true);
		_keyboxout.setVisible(false);
	}
	/*
	 * drag
	 */
	public void DragKeybox(MouseEvent e) {
		_keyboxin.setX(e.getX()-30);
		_keyboxin.setY(e.getY()-30);		
	}
	public void DragKey(MouseEvent e) {
		_keyin.setX(e.getX()-30);
		_keyin.setY(e.getY()-30);
		
	}
	public void DragCannon(MouseEvent e) {
		_cannonin.setX(e.getX()-30);
		_cannonin.setY(e.getY()-100);
		
	}
	/*
	 * put
	 */
	public void OpenBox(MouseEvent event) {//release the mouse then go back
		//System.out.println(_keyboxin.getX() + " " +_keyboxin.getY());
		if( _keyboxin.getX() >= 500 && _keyboxin.getX() <= 590 &&_keyboxin.getY() <= -70 &&_keyboxin.getY() >= -120) {
			_keyboxin.setVisible(false);
			_boxopen.setVisible(true);
			_boxclose.setVisible(false);
			_keyout.setVisible(true);
			boxopen = true;
		}
		else {
			_keyboxin.setX(2);
			_keyboxin.setY(-1);
		}
	}
	public void OpenDoor(MouseEvent event) {//release the mouse then go back
		//System.out.println(_keyin.getX() + " " +_keyin.getY());
		if( _keyin.getX() >= 270 && _keyin.getX() <= 400 &&_keyin.getY() <= -200 &&_keyin.getY() >= -400) {
			_keyin.setVisible(false);
			_doortwoopen.setVisible(true);
			dooropen = true;
		}
		else {
			_keyin.setX(2);
			_keyin.setY(-1);
		}
	}
	public void PutCannon(MouseEvent event) {
		//System.out.println(_cannonin.getX() + " " +_cannonin.getY());
		if( _cannonin.getX() >= 140 && _cannonin.getX() <= 250 &&_cannonin.getY() <= -85 &&_cannonin.getY() >= -150) {
			_cannonin.setVisible(false);
			_cannonout2.setVisible(true);
			cannonplace = true;
		}
		else {
			_cannonin.setX(2);
			_cannonin.setY(-1);
		}
	}
	/*
	 * key event
	 */
	public EventHandler<KeyEvent> onKeyPressed = (e)->{
		if (e.getCode() == KeyCode.LEFT) {
			//System.out.println(_penguinleft.getX());
			if(_penguinleft.getX() < -5 ) {
				 finalproject.mainStage.setScene(SceneoneController.secondScene);
				 _penguinleft.setVisible(false);
				_penguinright.setVisible(true);
			}
			else {
				_penguinleft.setX(_penguinleft.getX() - 15);
				_penguinright.setX(_penguinright.getX() - 15);
				_penguinleft.setVisible(true);
				_penguinright.setVisible(false);
				_penguinback.setVisible(false);
				_penguinfront.setVisible(false);
				_penguinfall.setVisible(false);
				_penguinfly.setVisible(false);
			}
		}
		if (e.getCode() == KeyCode.RIGHT) {
			//System.out.println(_penguinleft.getX());
			_penguinleft.setVisible(false);
			_penguinright.setVisible(true);
			_penguinback.setVisible(false);
			_penguinfront.setVisible(false);
			_penguinfly.setVisible(false);
			if(_penguinleft.getX() >= 615 ) {
				if(boxopen && dooropen == false) {
					_keyin.setVisible(true);
					_keyout.setVisible(false);
				}
			}
			else {
				if(_penguinleft.getX() == 195 && cannonplace) {
					_penguinfly.setX(0);
					_penguinfly.setY(0);
					_penguinfly.setVisible(true);
					_penguinright.setVisible(false);
					_penguinleft.setX(_penguinleft.getX() + 315);
					_penguinright.setX(_penguinright.getX() + 315);
					flyfly = true;
					animation();
				}
				else {
					if( _penguinleft.getX() == 285 && cannonplace == false && flyfly == false) {
						_penguinfall.setVisible(true);
						_penguinright.setVisible(false);
					}
					else {
						_penguinleft.setX(_penguinleft.getX() + 15);
						_penguinright.setX(_penguinright.getX() + 15);
					}
					
				}
				
			}
		} 
		if (e.getCode() == KeyCode.UP) {
			_penguinleft.setVisible(false);
			_penguinright.setVisible(false);
			_penguinback.setX(_penguinleft.getX());
			_penguinback.setY(_penguinleft.getY());
			_penguinback.setVisible(true);		
			_penguinfront.setVisible(false);
			_penguinfall.setVisible(false);
			_penguinfly.setVisible(false);
			if(dooropen == true && _penguinright.getX() > 550) {
				if(firsttime) {
					firsttime = false;
					FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenethree.fxml"));
					Parent third = null;
					try {
						third = loadder.load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					thirdScene = new Scene(third);
					ScenethreeController thirdCtrl = loadder.getController();
					thirdScene.setOnKeyPressed(thirdCtrl.onKeyPressed);
					finalproject.mainStage.setScene(thirdScene);
				}
				else
					finalproject.mainStage.setScene(thirdScene);				
			}
		}
		if (e.getCode() == KeyCode.DOWN) {
			
			_penguinfront.setX(_penguinleft.getX());
			_penguinfront.setY(_penguinleft.getY());
			_penguinfront.setVisible(true);
			_penguinleft.setVisible(false);
			_penguinright.setVisible(false);
			_penguinback.setVisible(false);
			_penguinfall.setVisible(false);
			_penguinfly.setVisible(false);
		}

	};

}

