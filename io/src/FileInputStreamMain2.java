import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamMain2 {
    public static void main(String[] args) {
//        InputStreamReader reader = null;
        //; InputStreamReader reader2 = new InputStreamReader(fis)
        try(FileInputStream fis = new FileInputStream("input.txt"); InputStreamReader reader = new InputStreamReader(fis)){
//            reader = new InputStreamReader(fis);
            int i;
            while ( (i = reader.read()) != -1){
                System.out.print((char)i);
            }
            System.out.println();
            System.out.println("end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if(reader2 != null){
//                try {
//                    reader2.close();
//                    System.out.println("now reader closed...");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
