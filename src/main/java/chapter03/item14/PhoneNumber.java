package chapter03.item14;

// Comparable 의 compareTo()에 대해서
// 1. compareTo는 동치성 비교와 순서를 비교하는 용도이다.
// 2. 제네릭 하다 -> 인스턴스를 생성할 때, 데이터 타입을 결정한다.
// 3. compareTo() 는 각 필드가 동치인지를 비교하는 것이 아닌 그 순서를 비교한다.
public class PhoneNumber implements Comparable<PhoneNumber> {
    private Short areaCode;
    private Short prefix;
    private Short lineNum;


    // 클래스의 핵심 필드가 여러 개일 경우, 가장 핵심이 되는 필드부터 compare 해야 한다.
    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        int result = Short.compare(areaCode, phoneNumber.areaCode); // 가장 중요한 필드
        if (result == 0) {
            result = Short.compare(prefix, phoneNumber.prefix); // 두 번째로 중요한 필드
            if (result == 0) {
                result = Short.compare(lineNum, phoneNumber.lineNum); // 세 번째로 중요한 필드
            }
        }
        return result;
    }
}
