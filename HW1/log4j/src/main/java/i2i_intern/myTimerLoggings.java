package i2i_intern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class myTimerLoggings {
    private final Logger logger;

    public myTimerLoggings() {
        logger = LogManager.getLogger(myTimerLoggings.class);
    }

    public void debug(String message) {
        this.logger.debug(message);
        //System.out.println("DEBUG: " + message);
    }

    public void info(String message) {
        this.logger.info(message);
        //System.out.println("INFO: " + message);
    }

    public void error(String message) {
        this.logger.error(message);
        //System.out.println("ERROR: " + message);
    }
}
