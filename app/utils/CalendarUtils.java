package utils;

import java.util.Calendar;

/**
 * Created by dustin on 2014/08/03.
 */
public class CalendarUtils {

    public static Calendar getCalendarDaysInFuture(int days)
    {
        Calendar cal  = Calendar.getInstance();
        cal.add(Calendar.DATE,days);
        return cal;
    }

}
