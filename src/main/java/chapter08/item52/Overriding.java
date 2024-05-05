package chapter08.item52;

import java.util.List;

// 재정의 메서드는 동적으로 매개변수 타입을 선택한다는 예시
class Wine {
    String name() { return "포도주"; }
}

class SparklingWine extends Wine {
    @Override String name() { return "발포성 포도주"; }
}

class Champagne extends SparklingWine {
    @Override String name() { return "샴페인"; }
}

public class Overriding {
    public static void main(String[] args) {
        List<Wine> windList = List.of(
                new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : windList) {
            System.out.println(wine.name());
        }
    }
}
