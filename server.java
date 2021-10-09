package ce1002.f1.s107502509;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class server {
	//receive the socket
	protected static   List<Socket> sockets = new Vector<>();
 
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5200);
		boolean flag = true;
		//receive client application
		
		while (flag){
			try {
				//wait for connection
				Socket accept = server.accept();
				synchronized (sockets){
					sockets.add(accept);
				}
				//multithread
				Thread thread = new Thread(new servertheard(accept));
				thread.start();
				
			}catch (Exception e){//error
				flag = false;
				e.printStackTrace();
			}
		}
		server.close();

    }
	
	
}