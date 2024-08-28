package chapter12.item89;

// 직렬화의 허점을 이용해 싱글턴 객체를 2개 생성한다
public class ElvisImpersonator {
    // 진짜 Elvis 인스턴스로는 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
            (byte)0xac, (byte) 0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x05,
            0x45, 0x6c, 0x76, 0x69, 0x73, (byte)0x84, (byte) 0xe6,
            (byte)0x93, 0x33, (byte)0xc3, (byte)0xf4, (byte)0x86
            // ..
    };

    public static void main(String[] args) {
        // ElvisStealer.impersonator 를 초기화한 다음
        // 진짜 Elvis(즉, Elvis.INSTANCE)를 반환한다.
        Elvis elvis = (Elvis) deserialize(serializedForm);
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }

    // 아이템88 에서 구현한 deserialize()
    private static Object deserialize(byte[] serializedForm) {
        return null;
    }
}
