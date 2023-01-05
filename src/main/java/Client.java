import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8081;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {
            out.println("Alex`s clint\n" + "Host: localhost\n\n\n");
            String resp = bufferedReader.readLine();
            System.out.println(resp);
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
