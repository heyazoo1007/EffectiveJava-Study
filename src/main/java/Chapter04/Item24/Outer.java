package Chapter04.Item24;

// 모양새
class Outer {

    public void B() {
        System.out.println("B 호출됨");
        Inner inner = new Inner();
        inner.A();
    }

    public void C() {
        System.out.println("C 호출됨");
    }

    public class Inner {

        public Inner() {
        }

        public void A() {
            System.out.println("A 호출됨");
            Outer.this.C();
        }
    }
}
