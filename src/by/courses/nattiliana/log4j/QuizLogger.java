package by.courses.nattiliana.log4j;

import org.apache.log4j.Logger;

/**
 * Created by Nataly on 24.11.2016.
 * ${VERSION}
 */
public class QuizLogger {

    private static Logger logger;

    @SuppressWarnings("rawtypes")
    public static void logError(Class sender, String message){
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}
