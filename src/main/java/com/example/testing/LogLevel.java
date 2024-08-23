package com.example.testing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogLevel {
    //onboarding levels in m/s estate.
    private static final Logger LOGGER = LoggerFactory.getLogger(LogLevel.class);

    public static void main(String[] args) {

        LOGGER.trace("Trace Message!");
        LOGGER.debug("Debug Message!");
        LOGGER.info("Info Message!");
        LOGGER.warn("Warn Message!");
        LOGGER.error("Error Message!");


    }


}
