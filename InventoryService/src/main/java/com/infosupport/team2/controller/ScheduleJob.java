package com.infosupport.team2.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by djones on 1/18/17.
 */
@Component
public class ScheduleJob {
    @Value("${csv.config.path}")
    private String configPath;

    private final static Logger logger = Logger.getLogger(ScheduleJob.class);
    private Timer timer = new Timer();
    @Autowired
    private CsvFileWriter csvFileWriter;

    @PostConstruct
    public void schedule(){
        long duration = 0;
        try {
            duration = getDuration();
            scheduleTask(duration);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Can't read duration from file", e);
        }
    }

    private long getDuration() throws IOException {
        Properties properties = new Properties();
        File file = new File(System.getProperty("user.dir") + configPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        String value = properties.getProperty("duur");
        Long longValueOfPropertiesFile = Long.parseLong(value);
        return TimeUnit.MINUTES.toMillis(longValueOfPropertiesFile);
    }

    private void scheduleTask(long duration) {
        csvFileWriter.setRefreshRate(duration);
        timer.schedule(csvFileWriter, 0, duration);
    }

}
