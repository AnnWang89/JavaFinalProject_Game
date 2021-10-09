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

public class ScenetwoController  extends finalproject implements Initializable{
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
	ImageView _paintone;
	@FXML
	ImageView _painttwo;
	@FXML
	ImageView _reelcloseout;
	@FXML
	ImageView _reelclosein;
	@FXML
	Group _reelopen;
	@FXML
	Group _paintthree;
	@FXML
	Group _vasepiece;
	@FXML
	ImageView _vase;
	@FXML
	Group _bigvase;
	@FXML
	ImageView _picture;
	@FXML
	ImageView _picture2;
	@FXML
	ImageView _picturebig;
	
	/*
	 * variable
	 */
	public static Scene secondtwoScene;
	public Scene vaseScene;
	boolean firsttime = true;
	boolean painttwofall = false;
	boolean paintonefall = false;
	boolean paintthreefall = false;
	public static String  line;
	/*
	 * time
	 */
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
	/*
	 * mouse event
	 */
	public void Puzzle (MouseEvent e) {
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/vase.fxml"));
		Parent vase = null;
		try {
			vase = loadder.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		vaseScene = new Scene(vase);
		finalproject.mainStage.setScene(vaseScene);
		_vasepiece.setVisible(false);
		_vase.setVisible(true);
	}
	public void PainttwoFall (MouseEvent e) {
		if(painttwofall) {
			_painttwo.setX(_painttwo.getX()-143);
			_painttwo.setY(_painttwo.getY()-106);
			painttwofall = false;
		}
		else {
			_painttwo.setX(_painttwo.getX()+143);
			_painttwo.setY(_painttwo.getY()+106);
			painttwofall = true;
		}
		
	}
	public void PaintoneFall (MouseEvent e) {
		if(paintonefall) {
			_paintone.setX(_paintone.getX()-46);
			_paintone.setY(_paintone.getY()-139);
			paintonefall = false;
		}
		else {
			_paintone.setX(_paintone.getX()+46);
			_paintone.setY(_paintone.getY()+139);
			paintonefall = true;
		}
		
	}
	public void TurnPaintthree (MouseEvent e) {
		if(paintthreefall) {
			_paintthree.setRotate(0);
			paintthreefall = false;
		}
		else {
			_paintthree.setRotate(-45);
			paintthreefall = true;
		}
		
	}
	public void CollectReelclose (MouseEvent e) {
		_reelclosein.setVisible(true);
		_reelcloseout.setVisible(false);
	}
	public void ShowReelopen (MouseEvent e) {
		_reelopen.setVisible(true);
		_reelclosein.setVisible(false);
	}
	public void CloseReel (MouseEvent e) {
		_reelopen.setVisible(false);
		_reelclosein.setVisible(true);
	}
	public void ShowBigvase (MouseEvent e) {
		_vase.setVisible(false);
		_bigvase.setVisible(true);
	}
	public void BackVase (MouseEvent e) {
		_vase.setVisible(true);
		_bigvase.setVisible(false);
	}
	public void PictureFall (MouseEvent e) {
		_picture.setVisible(false);
		_picture2.setVisible(true);
	}
	public void ShowBigpicture (MouseEvent e) {
		_picture2.setVisible(false);
		_picturebig.setVisible(true);
	}
	public void BackPicture (MouseEvent e) {
		_picture2.setVisible(true);
		_picturebig.setVisible(false);
	}
	
	/*
	public void nextscene2(MouseEvent e) throws IOException {//click the door to the next scene
		FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenetwo_2.fxml"));
	    Parent secondtwo = loadder.load();
	    secondtwoScene = new Scene(secondtwo);
	    ScenetwoController2 twoCtrl = loadder.getController();
	    secondtwoScene.setOnKeyPressed(twoCtrl.onKeyPressed);
	    finalproject.mainStage.setScene(secondtwoScene);
	}
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
			if(_penguinleft.getX() > 620 ) {
				if(firsttime) {
					firsttime = false;
					FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/scenetwo_2.fxml"));
					Parent secondtwo = null;
					try {
						secondtwo = loadder.load();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					secondtwoScene = new Scene(secondtwo);
					ScenetwoController2 twoCtrl = loadder.getController();
					secondtwoScene.setOnKeyPressed(twoCtrl.onKeyPressed);
					finalproject.mainStage.setScene(secondtwoScene);
				}
				else {
					finalproject.mainStage.setScene(secondtwoScene);
				}
				_penguinleft.setVisible(true);
				_penguinright.setVisible(false);
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
		if (e.getCode() == KeyCode.UP) {
			_penguinleft.setVisible(false);
			_penguinright.setVisible(false);
			_penguinback.setX(_penguinleft.getX());
			_penguinback.setY(_penguinleft.getY());
			_penguinback.setVisible(true);		
			_penguinfront.setVisible(false);
			if(_penguinleft.getX() >= -30 && _penguinleft.getX() <= 30) {
				finalproject.mainStage.setScene(MainController.firstScene);
				_penguinback.setVisible(false);		
				_penguinfront.setVisible(true);
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
