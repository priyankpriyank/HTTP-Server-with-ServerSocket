import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HTTPServer {
    public static void main(String[] args) throws Exception {
        final ServerSocket server1 = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            final Socket client = server1.accept();
            new Thread(() -> {
                try {
                    System.out.println("Your Connection is successful.");
                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + new Date();
                    OutputStream out = client.getOutputStream();
                    out.write(httpResponse.getBytes("UTF-8"));
                    client.close();  // Close the client connection
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();  // Start a new thread for each client
        }
    }
}
