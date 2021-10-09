package ce1002.f1.s107502509.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ScenethreeController extends finalproject implements Initializable{
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
	Rectangle _dooropen1;
	@FXML
	ImageView _dooropen2;
	@FXML
	ImageView _dooropen3;
	@FXML
	ImageView _windowopen;
	@FXML
	ImageView _windowclose;
	@FXML
	ImageView _tv;
	@FXML
	ImageView _tvcontrolin;
	@FXML
	ImageView _tvcontrolout;
	@FXML
	ImageView _ball;
	@FXML
	ImageView _fish;
	@FXML
	ImageView _fish1;
	@FXML
	Rectangle _tvback;
	
	/*
	 * variable
	 */

	static boolean code = false;
	boolean windowopen = true;
	boolean tvon = false;
	boolean f = true;
	boolean f1 = false;
	boolean f0 = true;
	boolean f10 = true;
	Timeline tvfish;
	public static String  line;
	/*
	 * 
	 * 
	 */
	public void initialize(URL arg0, ResourceBundle arg1) { 
		
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
		  //
		  tvfish = new Timeline(
					new KeyFrame(Duration.millis(10), (e1) -> {
						if(tvon==false) {
							_fish1.setVisible(false);
							_fish.setVisible(tvon);
						 }else {
							 	_fish.setVisible(f);
							 	_fish1.setVisible(f1);
							 	if(_fish.getX() > 140 ) {
							 		f = false;
							 		f1 = true;
							 	}
							 	if(_fish.getX() < 0 ) {
							 		f1 = false;
							 		f = true;
							
							 	}
							 	if(_fish.getY() < -72 ) {
							 		f10 = true;
							 		f0 = true;
							 		_fish.setRotate(180);
							 		_fish1.setRotate(180);
							
							 	}
							 	if(_fish.getY() > 0 ) {
							 		f10 = false;
							 		f0 = false;
							 		_fish.setRotate(0);
							 		_fish1.setRotate(270);
							 		
							 	}
							 	if(f) {
							 		_fish.setX(_fish.getX()+ 1 );
							 		_fish1.setX(_fish1.getX()+1 );
							 	}
							 	if(f1) {
							 		_fish.setX(_fish.getX()- 1 );
							 		_fish1.setX(_fish1.getX()- 1 );
							 	}
							 	if(f10) {
							 		_fish.setY(_fish.getY()+ 1 );
							 		_fish1.setY(_fish.getY()+ 1 );
							 	}else {
							 		_fish.setY(_fish.getY()- 1 );
							 		_fish1.setY(_fish.getY()- 1 );
						}
						//System.out.println("f "+ f +"f1 " + f1 + " f10 " + f10);
					}
					
			  }));//set the new time
			 tvfish.setCycleCount(Timeline.INDEFINITE);//will keep reset 
	}
	public void CombinationLock(MouseEvent e) throws IOException {//to enter the lock
		
		   
			FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenethree_lock.fxml"));
		    Parent three = loadder.load();
			Scene threeScene = new Scene(three);    			
			finalproject.mainStage.setScene(threeScene);
		
		
	}
	public void OnDoorPressed(MouseEvent e) {//success to escape
		if(code) {
			_dooropen1.setVisible(true);
			_dooropen2.setVisible(true);
			_dooropen3.setVisible(true);
		}
		
	}
	public void CloseWindow(MouseEvent e) {
		_windowopen.setVisible(false);
		_windowclose.setVisible(true);
		windowopen = false;
	}
	public void CollectTvcontrol(MouseEvent e) {
		_tvcontrolin.setVisible(true);
		_tvcontrolout.setVisible(false);
	}
	public void ControlTV(MouseEvent e) {
		if(tvon) {
			tvon = false;
			 tvfish.pause();
			 _fish1.setVisible(false);
			 _fish.setVisible(false);
		}else {
			tvon = true;
			tvfish.play();
		}
		_tvback.setVisible(tvon);
		

	
	
	}
	public EventHandler<KeyEvent> onKeyPressed = (e)->{
		if (e.getCode() == KeyCode.LEFT) {
			//System.out.println(_penguinleft.getX());
			if(_penguinleft.getX() <= 0 ) {
				finalproject.mainStage.setScene(ScenetwoController.secondtwoScene);
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
			}
		}
		if (e.getCode() == KeyCode.RIGHT) {
			//System.out.println(_penguinleft.getX());
			if(_penguinleft.getX() > 60 && windowopen) {
				   line=MainController.Name+" Game over..... ";
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
			if(_penguinleft.getX() > 675 ) {
			}
			else {
				if(_penguinleft.getX() >= (_ball.getX() + 240)) {
					
				}
				else {
					_penguinleft.setX(_penguinleft.getX() + 15);
					_penguinright.setX(_penguinright.getX() + 15);
					_penguinleft.setVisible(false);
					_penguinright.setVisible(true);
					_penguinback.setVisible(false);
					_penguinfront.setVisible(false);
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
			if(_penguinright.getX() >= 585 && code == true) {
				try {
					FileOutputStream fileout =new FileOutputStream("file/rank.txt",true);
					fileout.write((MainController.Name+"\t"+String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second)+"\n").getBytes());
					//fileout.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				line=MainController.Name+" Win!! Time left "+ String.format("%02d", MainController.minute) + ":" + String.format("%02d", MainController.second);
				out.println(line);
		        out.flush();
				FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/win.fxml"));
			    Parent win = null;
				try {
					win = loadder.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    Scene winScene = new Scene(win);    
			    finalproject.mainStage.setScene(winScene);
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
		if(e.getCode() == KeyCode.ENTER) {
			
			if(_penguinright.getX() == (_ball.getX() + 240)) {
				//System.out.println(_ball.getX());
				_ball.setX(_ball.getX() + 15);
				_ball.setRotate(_ball.getRotate() + 20);
				if(_penguinleft.getX() <= 675) {
					_penguinleft.setX(_penguinleft.getX() + 15);
				    _penguinright.setX(_penguinright.getX() + 15);
				}
				
				
			}
			
		}

	};
}
