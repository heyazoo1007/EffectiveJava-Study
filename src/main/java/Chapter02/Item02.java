package Chapter02;

import java.util.Date;
import java.time.Instant;
import java.util.Random;

public class Item02 {

    // example of Static Factory Method
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public Instant instant;
    Date d = Date.from(instant);
}
