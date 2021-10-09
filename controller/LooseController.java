package ce1002.f1.s107502509.controller;

import java.io.IOException;

import ce1002.f1.s107502509.finalproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LooseController  extends finalproject{
	public static String  line;
	public void PlayAgain(ActionEvent e) throws IOException {
		line=MainController.Name+" Play again! ";
		out.println(line);
        out.flush();
	    FXMLLoader loadder = new FXMLLoader(getClass().getResource("../views/sceneone.fxml"));
	    Parent first = loadder.load();
	    Scene firstScene = new Scene(first);
	    SceneoneController onecontrol = loadder.getController();
	    firstScene.setOnKeyPressed(onecontrol.onKeyPressed);
	    finalproject.mainStage.setScene(firstScene);
	    MainController.minute = 5;
	    MainController.second = 1;
	}
	public void OnExitPressed(ActionEvent e) {
		line=MainController.Name+" Quit. ";
		out.println(line);
        out.flush();
		finalproject.mainStage.close();
	}

}
