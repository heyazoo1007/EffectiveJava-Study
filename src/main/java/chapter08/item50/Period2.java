package chapter08.item50;

import java.util.Date;

// 매개변수 방어적 복사하는 경우
public class Period2 {
    private final Date start;
    private final Date end;

    public Period2(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(
                    start + "가 " + end + "보다 늦다.");
        }
    }

    public Date start() { return new Date(start.getTime()); }

    public Date end() {return new Date(end.getTime()); }
}
