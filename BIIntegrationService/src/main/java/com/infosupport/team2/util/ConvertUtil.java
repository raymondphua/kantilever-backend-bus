package com.infosupport.team2.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Robin on 23-1-2017.
 */
public class ConvertUtil {
    public static String historyFromMinutes(int minutes){
        Date date = new Date();
        Date historyDate = DateUtils.addMinutes(date, (int) -minutes);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = simpleDateFormat.format(historyDate);

        return dateString;
    }
}
