import java.io.*;
import java.net.*;

public class client{

    public void go(){
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader =new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice= reader.readLine();
            System.out.println("Today you should: "+ advice);
            reader.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        client c= new client();
        c.go();
    }

}