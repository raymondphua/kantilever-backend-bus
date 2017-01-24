package com.infosupport.team2.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by djones on 1/18/17.
 */
@Component
public class ScheduleJob {

    private final static Logger logger = Logger.getLogger(ScheduleJob.class);
    private Timer timer = new Timer();
    @Autowired
    private CsvFileWriter csvFileWriter;

    @PostConstruct
    public void schedule() throws IOException {
        long duration = getDuration();
        scheduleTask(duration);
    }

    private long getDuration() throws IOException {
        Properties properties = new Properties();
        File file = new File("/home/djones/Desktop/asd/test.properties");
        FileInputStream fileInputStream = null;
        Long longValueOfPropertiesFile = 0L;
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            String value = properties.getProperty("duur");
            longValueOfPropertiesFile = Long.parseLong(value);
        } catch(Exception e) {
            logger.error(e.getLocalizedMessage());
        } finally {
            fileInputStream.close();
        }

        return TimeUnit.MINUTES.toMillis(longValueOfPropertiesFile);
    }

    private void scheduleTask(long duration) {
        csvFileWriter.setRefreshRate(duration);
        timer.schedule(csvFileWriter, 0, duration);
    }

}
