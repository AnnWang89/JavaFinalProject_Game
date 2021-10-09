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
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SceneoneController extends finalproject implements Initializable{

	@FXML
	Label _time;
	@FXML
	ImageView _keyout;
	@FXML
	ImageView _keyin;
	@FXML
	ImageView _boneout;
	@FXML
	ImageView _bonein;
	@FXML
	ImageView _firein;
	@FXML
	ImageView _fireout;
	@FXML
	ImageView _nofirein;
	@FXML
	ImageView _nofireout;
	@FXML
	ImageView _lighterout;
	@FXML
	ImageView _lighterin;
	@FXML
	ImageView _door1open;
	@FXML
	ImageView _door1lock;
	@FXML
	ImageView _cageclose;
	@FXML
	ImageView _cageopen;
	@FXML
	ImageView _dog;
	@FXML
	ImageView _dogwithbone;
	@FXML
	ImageView _cagekeyondog;
	@FXML
	ImageView _cagekeyin;
	@FXML
	ImageView _cagekey;
	@FXML
	ImageView _firstdogwithbone;
	@FXML
	Rectangle _dark;
	@FXML
	ImageView _penguinright;
	@FXML
	ImageView _penguinleft;
	@FXML
	Rectangle _insidedoor;
	@FXML
	ImageView _penguinback;
	@FXML
	ImageView _penguinfront;
	@FXML
	ImageView _book;
	@FXML
	ImageView _bookfall;
	@FXML
	ImageView _board;
	
	/*
	 * variable
	 */
	boolean cageopen = false ;
	boolean dooropen = false ;
	boolean boardcover = true;
	boolean firsttime = true;
	public static Scene secondScene;
	public static String  line;
	/*
	 * time
	 */
	public void initialize(URL arg0, ResourceBundle arg1) { 
		
		MainController.fps = new Timeline(
				new KeyFrame(Duration.millis(1000), (e) -> {
			//MainController.second--;
		   if (MainController.minute == 0 && MainController.second == 0) {
			   line= MainController.Name+" Game over..... ";
			   out.println(line);
		       out.flush();
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
	/*
	 * door
	 */
	
	
	/*
	 * mouse event(drag)
	 */
	public void DragKey(MouseEvent e) {
		_keyin.setX(e.getX()-30);
		_keyin.setY(e.getY()-30);
		
	}
	public void DragBone(MouseEvent e) {
		_bonein.setX(e.getX()-30);
		_bonein.setY(e.getY()-20);
		
	}
	public void DragLighter(MouseEvent e) {
		_lighterin.setX(e.getX()-30);
		_lighterin.setY(e.getY()-30);
		
	}
	public void DragFire(MouseEvent e) {
		_fireout.setX(e.getX()-30);
		_fireout.setY(e.getY()-70);
		
	}
	public void DragCageKey(MouseEvent e) {
		_cagekeyin.setX(e.getX()-30);
		_cagekeyin.setY(e.getY()-30);
		
	}
	public void PutKeyBack(MouseEvent event) {//release the mouse then go back
		//System.out.println(_keyin.getX() + " " +_keyin.getY());
		if( _keyin.getX() >= 640 && _keyin.getX() <= 720 &&_keyin.getY() <= -200 &&_keyin.getY() >= -400) {
			_keyin.setVisible(false);
			_door1open.setVisible(true);
			_insidedoor.setVisible(true);
			dooropen = true;
		}
		else {
			_keyin.setX(2);
			_keyin.setY(-1);
		}
	}
	public void PutBoneBack(MouseEvent event) {//release the mouse then go back
		//System.out.println(_bonein.getX() + " " +_bonein.getY());
		if(_bonein.getX() >= 620 && _bonein.getX() <= 680 &&_bonein.getY() <= -95 &&_bonein.getY() >= -170) {
			_bonein.setVisible(false);
			_firstdogwithbone.setVisible(true);
		}
		else {
			_bonein.setX(1);
			_bonein.setY(1);
		}
	}
	public void PutLighterBack(MouseEvent event) {//release the mouse then go back
		//System.out.println(_lighterin.getX() + " " +_lighterin.getY());
		if(_lighterin.getX() >= 55 && _lighterin.getX() <= 110 &&_lighterin.getY() <= 20 &&_lighterin.getY() >= -30) {
			_lighterin.setVisible(false);
			_firein.setVisible(true);
			_nofirein.setVisible(false);
		}
		else {
			_lighterin.setX(5);
			_lighterin.setY(1);
		}
	}
	public void PutFire(MouseEvent event) {//release the mouse then go back
		//System.out.println(_fireout.getX() + " " +_fireout.getY());
		if( _fireout.getX() >= -270 && _fireout.getX() <= 560 &&_fireout.getY() <= 135 &&_fireout.getY() >= 65) {
			_fireout.setVisible(false);
			_fireout.setX(0);
			_fireout.setY(0);
			_firein.setVisible(true);
			_dark.setVisible(true);
		}
		else
			_dark.setVisible(false);
	}
	public void ShowFire(MouseEvent e) {//change small fire to big fire
		_firein.setVisible(false);
		_fireout.setVisible(true);
	}
	public void OpenCage(MouseEvent event) {//release the mouse then go back
		//System.out.println(_cagekeyin.getX() + " " +_cagekeyin.getY());
		if(_cagekeyin.getX() >= -125 && _cagekeyin.getX() <= -75 &&_cagekeyin.getY() <= -150 &&_cagekeyin.getY() >= -290) {
			_cagekeyin.setVisible(false);
			_cageclose.setVisible(false);
			_cageopen.setVisible(true);
			cageopen = true;
		}
		else {
			_cagekeyin.setX(1);
			_cagekeyin.setY(1);
		}
	}
	/*
	 * collect things
	 */
	public void CollectKey(MouseEvent e) {//put the key in the box
		_keyin.setVisible(true);
		_keyout.setVisible(false);
	}
	public void CollectBone(MouseEvent e) {//put the bone in the box
		_bonein.setVisible(true);
		_boneout.setVisible(false);
	}
	public void CollectFire(MouseEvent e) {//put the bone in the box
		_nofirein.setVisible(true);
		_nofireout.setVisible(false);
	}
	public void CollectLighter(MouseEvent e) {//put the bone in the box
		_lighterin.setVisible(true);
		_lighterout.setVisible(false);
		
		
	}
	public void CollectCageKey(MouseEvent e) {//put the bone in the box
		_cagekeyin.setVisible(true);
		_cagekeyondog.setVisible(false);
	}
	public void CallDog(MouseEvent e) {//dog come to front
		_dogwithbone.setVisible(true);
		_cagekeyondog.setVisible(true);
		_firstdogwithbone.setVisible(false);
		_cagekey.setVisible(false);
		_dog.setVisible(false);
	}
	public void ShowBone(MouseEvent e) {
		if(boardcover) {
			_board.setY(_board.getY()+170);
			_board.setX(_board.getX()-20);
			boardcover = false;
		}
		else {
			_board.setY(_board.getY()-170);
			_board.setX(_board.getX()+20);
			boardcover = true;
		}
			
	}
	/*
	 * key event
	 */
	public EventHandler<KeyEvent> onKeyPressed = (e)->{
		if (e.getCode() == KeyCode.LEFT) {
			
			//System.out.println(_penguinleft.getX());
			if(_penguinleft.getX() < -15 ) {
			}
			else {
				_penguinleft.setX(_penguinleft.getX() - 15);
				_penguinright.setX(_penguinright.getX() - 15);
				_penguinleft.setVisible(true);
				_penguinright.setVisible(false);
				_penguinback.setVisible(false);
				_penguinfront.setVisible(false);
			}
		}
		if (e.getCode() == KeyCode.RIGHT) {
			
			//System.out.println(_penguinleft.getX());
			if(_penguinleft.getX() > 615 ) {
			}
			else {
				if(!cageopen) {
					if(_penguinleft.getX() >= 45) {
					}
					else {
						_penguinleft.setX(_penguinleft.getX() + 15);
						_penguinright.setX(_penguinright.getX() + 15);
					}
				}
				else {
					_penguinleft.setX(_penguinleft.getX() + 15);
					_penguinright.setX(_penguinright.getX() + 15);
				}
				_penguinleft.setVisible(false);
				_penguinright.setVisible(true);
				_penguinback.setVisible(false);
				_penguinfront.setVisible(false);
			}
		} 
		if (e.getCode() == KeyCode.UP) {
			_penguinleft.setVisible(false);
			_penguinright.setVisible(false);
			_penguinfront.setVisible(false);
			_penguinback.setX(_penguinleft.getX());
			_penguinback.setY(_penguinleft.getY());
			_penguinfront.setX(_penguinleft.getX());
			_penguinfront.setY(_penguinleft.getY());
			_penguinback.setVisible(true);
			if(_penguinleft.getX() >= 330 && _penguinleft.getX() <= 435 && dooropen == false ) {
				_book.setVisible(false);
				_bookfall.setVisible(true);
				_keyout.setVisible(true);
			}
			if(_penguinright.getX() >= 480 && _penguinright.getX() <= 580 && dooropen == true) {
				if(firsttime) {
					firsttime = false;
					FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenetwo_1.fxml"));
					Parent second = null;
					try {
						second = loadder.load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					secondScene = new Scene(second);
					ScenetwoController twoCtrl = loadder.getController();
					secondScene.setOnKeyPressed(twoCtrl.onKeyPressed);
					finalproject.mainStage.setScene(secondScene);
					_penguinfront.setVisible(true);
					_penguinback.setVisible(false);
				}
				else {
					finalproject.mainStage.setScene(secondScene);
					_penguinfront.setVisible(true);
					_penguinback.setVisible(false);
				}
					
					
				
			}
		}
		if (e.getCode() == KeyCode.DOWN) {
			_penguinfront.setX(_penguinleft.getX());
			_penguinfront.setY(_penguinleft.getY());
			_penguinfront.setVisible(true);
			_penguinleft.setVisible(false);
			_penguinright.setVisible(false);
			_penguinback.setVisible(false);
		}
	};	  
}
	