import java.io.*;

public class FileCopyTest {
    public static void main(String[] args) {
        long millisecond = 0;
        try(
            FileInputStream fis = new FileInputStream("a.zip");
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream("copy.zip");
            BufferedOutputStream bos = new BufferedOutputStream(fos)
        ){
            millisecond = System.currentTimeMillis();

            int i;
//            while((i = fis.read()) != -1){
//                fos.write(i);
//            }
            while((i = bis.read()) != -1){
                bos.write(i);
            }
            millisecond = System.currentTimeMillis() - millisecond;
        }catch(IOException error){
            error.printStackTrace();
        }
        System.out.println(millisecond + " 소요");

    }
}
