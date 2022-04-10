import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class FileInputStreamMain3 {
    public static void main(String[] args) {
        int i;
        try(FileInputStream fis = new FileInputStream("input2.txt")){
            byte[] bs = new byte[10];
            while((i = fis.read(bs, 1, 9)) != -1) {
//                for(int ch: bs){
                for(int j = 0; j < i; j++){
//                    System.out.println((char) ch);
                    System.out.print((char) bs[j]);
                }
                System.out.println(" " + i + " bytes");
            }
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
    }
}
