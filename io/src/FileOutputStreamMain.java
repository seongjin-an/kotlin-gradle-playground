import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("output.txt")){
            fos.write(65);
            fos.write(66);
            fos.write(67);
        }catch(IOException error){//IOException <- FileNotFoundException
            System.out.println(error.getMessage());
        }
        System.out.println("end");
    }
}
