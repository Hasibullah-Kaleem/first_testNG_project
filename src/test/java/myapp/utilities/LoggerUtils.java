<<<<<<< HEAD

=======
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
package myapp.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {
<<<<<<< HEAD

    //    This Util class is used to log info in Test classes
    private static Logger logger = LogManager.getLogger(myapp.utilities.LoggerUtils.class.getName());
    public static void debug(String message){
        logger.debug(message);
    }
    public static void info(String message){
        logger.info(message);
    }
    public static void warn(String message){
        logger.warn(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void fatal(String message){
        logger.fatal(message);
    }
}
=======
    
        //    This Util class is used to log info in Test classes
        private static Logger logger = LogManager.getLogger(myapp.utilities.LoggerUtils.class.getName());
        public static void debug(String message){
            logger.debug(message);
        }
        public static void info(String message){
            logger.info(message);
        }
        public static void warn(String message){
            logger.warn(message);
        }
        public static void error(String message){
            logger.error(message);
        }
        public static void fatal(String message){
            logger.fatal(message);
        }
}
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
