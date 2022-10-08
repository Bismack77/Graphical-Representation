/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q8server;

/**
 *
 * @author Asus
 */
//import java.until.timer;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static q8server.Q8server.count;
import static q8server.Q8server.ds2;
import static q8server.Q8server.ia2;
import static q8server.Q8server.inp2;
import static q8server.Q8server.strLine2;
class helper extends TimerTask
{
    public static int i = 0;
    @Override
    public void run()
    {

                  System.out.println(" Line no:" + count);
        count++;
        strLine2=inp2.nextLine();          
             byte[] b2 = strLine2.getBytes();
                DatagramPacket dp2= new DatagramPacket(b2,b2.length,ia2,4567);
        try {
            ds2.send(dp2);
        } catch (IOException ex) {
            Logger.getLogger(helper.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        System.out.println("Sending Line " + strLine2);
       
       
    }
}
 
public class Q8server {
public static int count=1;
public static String strLine2;
public static Scanner inp2;
public static DatagramSocket ds2;
public static InetAddress ia2;
    public static void main(String[] args) throws SocketException, UnknownHostException, FileNotFoundException {
         ds2= new DatagramSocket();
        ia2= InetAddress.getByName("localhost"); 
      inp2 = new Scanner(new File("D:\\InpText2.txt"));
             Timer timer = new Timer();
        helper task = new helper();

        timer.schedule(task,0, 200);
    }
    
}
