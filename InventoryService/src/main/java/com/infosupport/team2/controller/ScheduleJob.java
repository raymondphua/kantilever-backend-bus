package com.infosupport.team2.controller;

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

    private Timer timer = new Timer();
    @Autowired
    private CsvFileWriter csvFileWriter;

    @PostConstruct
    public void schedule() throws IOException {
        Properties properties = new Properties();
        File file = new File("/home/djones/Desktop/asd/test.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        String value = properties.getProperty("duur");
        Long parseStringToLong = Long.parseLong(value);
        long mili = TimeUnit.MINUTES.toMillis(parseStringToLong);
        csvFileWriter.setRefreshRate(parseStringToLong);
        timer.schedule(csvFileWriter, 0, mili);

    }

}
