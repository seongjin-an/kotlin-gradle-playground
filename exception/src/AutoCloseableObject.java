
import java.lang.AutoCloseable;

public class AutoCloseableObject implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("closed automatically");
    }

}
