import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Thread thread;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
}
    public void startServer(){
        try{
            while(!serverSocket.isClosed()){

                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!"); 
                ClientHandler clienHandler = new ClientHandler();

                thread = new Thread(clienHandler);
                thread.start();

            }
        }
        catch(IOException e) {
            
        }
    }
}