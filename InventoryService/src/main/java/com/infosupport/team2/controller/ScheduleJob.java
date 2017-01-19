package com.infosupport.team2.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PostConstruct
    public void schedule() throws IOException {
        Properties properties = new Properties();
        File file = new File("/home/djones/Desktop/asd/test.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        String value = properties.getProperty("duur");
        Long parseStringToLong = Long.parseLong(value);
        long mili = TimeUnit.MINUTES.toMillis(parseStringToLong);
        timer.schedule(new CsvFileWriter(), 0, mili);
    }

}
