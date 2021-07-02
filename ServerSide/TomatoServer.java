import java.net.*;
import java.io.*;
public class TomatoServer
{
    public static void main(String[] args) {
       while (true) {
        try{
            
            ServerSocket ss = new ServerSocket(5678);
            Socket s = ss.accept();
            System.out.println("\n\nOrder Received");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String pcno = (String)dis.readUTF();
            String foodname = (String)dis.readUTF();
            String money = (String)dis.readUTF();
            System.out.println("At PC Number: "+pcno+"\nOrder is: "+foodname+"\nTotal Money is: "+money);
            ss.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
       }
    }
}