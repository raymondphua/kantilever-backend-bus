package com.infosupport.team2.util;

import java.time.Instant;

/**
 * Created by Robin on 23-1-2017.
 */
public class ConvertUtil {
    public static long historyFromMinutes(int minutes) {
        Instant date = Instant.now();
        date = date.minusSeconds(minutes * 60);

        return date.toEpochMilli();
    }
}
