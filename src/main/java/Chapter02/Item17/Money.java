package Chapter02.Item17;

// Item17 : 변경 가능성을 최소화하라
// 클래스가 꼭 필요한 경우가 아니라면 불변으로 만들자
// getter 가 있다고 setter 를 만들지 말자
// 단순 값객체의 경우 항상 불변으로 하자 (ex. Money)
// 성능이 아쉬운 경우는 가변 동반 클래스를 제공하자 (ex. StringBuilder)
// 불변으로 만들 수 없다면 변경할 수 있는 부분을 최소한으로 만들자
// 다른 합당한 이유가 없다면 모든 필드는 private final 로 선언하자
// 생성자는 불변식 설정이 모두 완료된, 초기화가 완벽히 끝난 상태의 객체를 생성하자

final class Money {
    private final int value;
    Money(int value) {
        this.value = value;
    }

    Money one = new Money(1);
    Money zeroAmount = new Money(0);
}



