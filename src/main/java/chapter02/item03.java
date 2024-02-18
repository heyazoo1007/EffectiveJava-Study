package chapter02;

public class item03 {

    // Case01 : public static 멤버가 final 필드인 방식
    public static final item03 INSTANCE1 = new item03();
    //리플렉션을 통해 두 번째 객체가 생성되려고 할때 예외 발생시키는 방법
    private item03() {
        if(INSTANCE1 != null){
            throw new RuntimeException("생성자를 호출할 수 없습니다!");
        }
    }

    // Case02 : 정적 팩토리 메서드를 public static 멤버로 제공하는 방식
    private static final item03 INSTANCE2 = new item03();
    public static final item03 getInstance() {
        return INSTANCE2;
    }

    // + 정적 팩터리 메서드 참조를 공급자로 사용 가능 & 직렬화, readResolve()
}
