package chapter05.item26;

// Item26 : 로 타입은 사용하지 말라
// 로 타입을 사용하면 타입 안정성이 보장되지 않아 좋지 않다.
public class RawType {

    // 로 타입
    // private final Collection stamps = {...};
    // stamps.add(new Coin(...));

    // 위 코드에서 발생할 수 있는 문제점
    // add() 하는 시점에는 에러가 발생하지 않지만
    // 추후에 런타임 에러 가능성이 있고, 원인 코드를 추적하기가 어려워짐

    // 해결책
    // private final Collection<Stamp> stamps = {...}; -> 제네릭으로 타입 안정성 확보
    // stamps.add(new Coin(...)); -> 컴파일 에러 발생으로 문제 즉시 해결
}
