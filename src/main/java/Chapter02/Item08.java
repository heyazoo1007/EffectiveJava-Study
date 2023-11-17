package Chapter02;

import java.lang.ref.Cleaner;

public class Item08 {

    // finalizer 와 cleaner 사용을 피하라는 이유

    // 1. 즉시 수행 안됨
    // 2. 실행된다는 보장도 없음
    // 3. 성능 문제 + finalizer 는 보안문제까지 있음
    // 4. finalizer 는 exception 발생 시 리소스 정리 작업이 처리되지 않을 수 있음

    // 대안책
    // 1. AutoClosable 을 구현하고 클라이언트에서 클로즈 호출
    // 2. try-with-resource-로 구현


    // Cleaner 사용되는 예제
    // cleaner 는 즉시 호출된다는 보장은 없지만, 자원 회술ㄹ 늦게라도 해주므로 안전망 역할을 한다.
    public static class Room implements AutoCloseable {
        private static final Cleaner cleaner = Cleaner.create();


        // Room 을 참조하면 순환으로 참조하기에 GC의 대상이 되지 않으므로 Room 을 참조해서는 안된다.
        // 청소가 필요한 자원, cleaner 가 청소할 때 수거할 자원을 가진다.
        private static class State implements Runnable {
            int numJunkPiles;

            public State(final int numJunkPiles) {
                this.numJunkPiles = numJunkPiles;
            }

            @Override
            public void run() {
                System.out.println("방청소");
                numJunkPiles = 0;
            }
        }

        private final State state;
        private final Cleaner.Cleanable cleanable;

        public Room(final int numJunkFiles) {
            this.state = new State(numJunkFiles);
            cleanable = cleaner.register(this, state);
        }

        @Override
        public void close() throws Exception {
            cleanable.clean();
        }
    }
}
