package ce1002.f1.s107502509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class servertheard extends server implements Runnable{

    Socket socket;
    String socketName;
    public static String output;
    
    public servertheard(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            socketName = socket.getRemoteSocketAddress().toString();
            System.out.println(socketName+"  connected.");
            print(socketName+"  connected.");
            boolean flag = true;
            while (flag){
                String line = reader.readLine();
                if (line == null){
                    flag = false;
                    continue;
                }
                String msg =line;
                
                System.out.println(msg);
                
                //print message to the client
                print(msg);
            }


            closeConnect();
        } catch (IOException e) {
            try {
                closeConnect();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void print(String msg) throws IOException {
        PrintWriter out = null;
        output=msg;
        synchronized (sockets){
        for (Socket sc : sockets){
            out = new PrintWriter(sc.getOutputStream());            
            out.println(msg);
            out.flush();
        }
    }
    }

    public void closeConnect() throws IOException {
        System.out.println(socketName+"  disconnected.");
        print(socketName + "  disconnected.");
        synchronized (sockets){
            sockets.remove(socket);
        }
        socket.close();
    }
    
    
   
}