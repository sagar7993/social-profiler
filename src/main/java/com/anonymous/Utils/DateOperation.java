package com.anonymous.Utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by akash.mercer on 15-05-2016.
 */
public class DateOperation {

    public static Date getDateFromLong(Long timeInMillis){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar.getTime();
    }

    public static int getDateTypeFromLong(Long timeInMillis){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}
