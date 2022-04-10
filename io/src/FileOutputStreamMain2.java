import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain2 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("output.txt")){
            byte[] bs = new byte[26];
            byte data = 65;
            for(int i = 0; i < bs.length; i++){
                bs[i] = data++;
            }
            fos.write(bs);
        }catch(IOException error){
            error.printStackTrace();
        }
        System.out.println("end");
    }
}
