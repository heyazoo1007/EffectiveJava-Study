package Chapter03.Item13;

public final class PhoneNumber implements Cloneable {

    // 가변 상태를 참조하지 않는 클래스용 clone 메서드
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // PhoneNumber 가 final 이라 일어나지 않는다.
        }
    }
}
