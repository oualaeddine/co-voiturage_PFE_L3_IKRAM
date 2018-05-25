package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {

    public static Date getDateFromString(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            java.util.Date date = sdf.parse(dateString);
            date1 = new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
}
