package com.infosupport.team2.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        File file = new File(System.getProperty("user.dir") + "/config.properties");
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
