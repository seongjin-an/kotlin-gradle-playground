import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
    public static void main(String[] args) {
//        try(FileInputStream fis = new FileInputStream("input.txt")){
        try(FileReader fis = new FileReader("input.txt")){
            int i;
            while((i = fis.read()) != -1){
                System.out.print((char) i);
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
