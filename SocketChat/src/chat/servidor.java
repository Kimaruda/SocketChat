
package chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class servidor {
 
    public void run(){
        try {
            System.out.println("Servidor Listo!");
            paquete recibido;
            ServerSocket server = new ServerSocket(4242);
            while(true){
                Socket sock= server.accept();
                ObjectInputStream paqueteServidor= new ObjectInputStream(sock.getInputStream()); 
                recibido= (paquete)paqueteServidor.readObject();
                
                Socket envio = new Socket(recibido.getDireccion(),4242);
                ObjectOutputStream paqueteReenvio= new ObjectOutputStream(envio.getOutputStream());
                
                paqueteReenvio.writeObject(recibido);
                envio.close();
                
                sock.close();
            }
        } catch (Exception e) {
            
        } 
    }

    public static void main(String[] args) {
        servidor s = new servidor();
        s.run();
    }
}
