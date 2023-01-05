import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("1");
                Socket clientSocket = serverSocket.accept();
                System.out.println("2");
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("3");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("4");

                System.out.println("New connection accepted");
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
