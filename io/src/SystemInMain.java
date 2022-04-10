import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInMain {
    public static void main(String[] args) {
        System.out.println("알파벳 여러 개를 쓰고 엔터키 입력");
        int i;
        try{
            InputStreamReader irs = new InputStreamReader(System.in);//보조스트림
//            while((i = System.in.read()) != '\n') {//InputStream 은 1바이트씩 읽음.
            while((i = irs.read()) != '\n') {
                System.out.print((char) i);
            }
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
