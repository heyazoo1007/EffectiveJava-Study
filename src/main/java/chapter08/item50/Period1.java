package chapter08.item50;

import java.util.Date;

// 아이템50 : 적시에 방어적 복사본을 만들라

// Date 가 가변 객체이기 때문에 클라이언트로부터의 변경 가능성을 가지고 있다.
// 불변 객체가 깨질 수 있는 클래스
public class Period1 {
    private final Date start;
    private final Date end;

    public Period1(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(
                    start + "가 " + end + "보다 늦다.");
        }
        this.start = start;
        this.end = end;
    }

    public Date start() { return start; }

    public Date end() {return end; }
}
