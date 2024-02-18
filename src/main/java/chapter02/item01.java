package chapter02;

import java.util.Date;
import java.time.Instant;

public class item01 {

    // example of Static Factory Method
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public Instant instant;
    Date d = Date.from(instant);
}
