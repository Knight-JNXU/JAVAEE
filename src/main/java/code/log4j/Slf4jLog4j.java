package code.log4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

public class Slf4jLog4j{

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Slf4jLog4j.class);
    @Test
    public void getFactoryClass(){
        LOGGER.debug("log level : {}", "debug");
        LOGGER.info("log level : {}", "info");
        LOGGER.warn("log level : {}", "warn");
        LOGGER.error("log level : {}", "error");
    }

    @Test
    public void utilReportTest(){
        Util.report("utilReportTest");

        org.apache.log4j.spi.LoggerFactory
    }
}
