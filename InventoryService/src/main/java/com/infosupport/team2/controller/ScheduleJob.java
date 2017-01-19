package com.infosupport.team2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by djones on 1/18/17.
 */
@Controller
public class ScheduleJob {

    private Timer timer = new Timer();

    @RequestMapping(value = "/timer", method = RequestMethod.GET)
    public void schedule(@RequestParam(value = "period") long period) {
        long mili = TimeUnit.MINUTES.toMillis(period);
        timer.schedule(new CsvFileWriter(), 0, mili);
    }

    @RequestMapping(value = "/timerstop", method = RequestMethod.GET)
    public void cancelTimer() {
        timer.cancel();
    }
}
