import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            br.read();
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
