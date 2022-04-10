import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomizedLogger {
    // severe, warning, info, config, fine, finer, finest
    Logger logger = Logger.getLogger("Customized Logger");
    private static CustomizedLogger instance = new CustomizedLogger();

    public static final String ERROR_LOG = "log.txt";
    public static final String WARNING_LOG = "warning,txt";
    public static final String FINE_LOG = "fine.txt";

    private FileHandler logFile = null;
    private FileHandler warningFile = null;
    private FileHandler fineFile = null;

    private CustomizedLogger(){
        try{
            logFile = new FileHandler(ERROR_LOG, true);
            warningFile = new FileHandler(WARNING_LOG, true);
            fineFile = new FileHandler(FINE_LOG, true);
        }catch(SecurityException error){
            error.printStackTrace();
        }catch(IOException error){
            error.printStackTrace();
        }
        logFile.setFormatter(new SimpleFormatter());
        warningFile.setFormatter(new SimpleFormatter());
        fineFile.setFormatter(new SimpleFormatter());

        logger.setLevel(Level.ALL);
        fineFile.setLevel(Level.FINE);
        warningFile.setLevel(Level.WARNING);

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
        logger.addHandler(fineFile);
    }

    public static CustomizedLogger getLogger(){
        return instance;
    }

    public void log(String msg){
        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);
    }

    public void fine(String msg){
        logger.fine(msg);
    }

    public void warning(String msg){
        logger.warning(msg);
    }
}
