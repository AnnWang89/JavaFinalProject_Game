/*
 * Final Project
 * Course: ce1002
 * Name: ¤ý§g¦w
 * Student ID: 107502509
 */
package ce1002.f1.s107502509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class finalproject extends Application{

	public static Stage mainStage;
	public static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		finalproject.mainStage = primaryStage;
	    FXMLLoader loadder = new FXMLLoader(getClass().getResource("views/main.fxml"));//
	    Parent main = loadder.load();    
	    mainScene = new Scene(main);
	    mainStage.setTitle("Escape from the Castle");//title name
	    mainStage.setScene(mainScene);//set scene to mainScene
	   
	    mainStage.show();//show the Stage
	}
	public static Socket socket;
	public static BufferedReader reader;
	public static PrintWriter out;
	public static BufferedReader in;
	public static String  line;
    public static void main(String[] args) throws IOException {
        //connection Ip and socket
        socket = new Socket("127.0.0.1",5200);
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(in.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        launch(args);
        line = "end";
        if("end".equalsIgnoreCase(line))
        {
        	out.close();
            in.close();
            socket.close();
        }
    }
	

}

