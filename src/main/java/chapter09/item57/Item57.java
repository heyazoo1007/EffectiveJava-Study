package chapter09.item57;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 아이템57 : 지역변수의 범위를 최소화하라
 */
public class Item57 {

    // 예시1 : 컬렉션이나 배열을 순회하는 권장 관용구
    public static void main1(String[] args) {
        ArrayList<String> elements = new ArrayList<>();
        for (String element : elements) {
            // element 를 사용한 로직
        }
    }

    public static void main2(String[] args) {
        // 예시 2-1 : 반복자가 필요할 떄의 관용구
        ArrayList<Element> elements = new ArrayList<>();
        for (Iterator<Element> i = elements.iterator(); i.hasNext();) {
            Element e = i.next();
            // e 와 i 를 사용한 로직
        }

        // 예시 2-2 : while 문 사용시 주의해야할 점 - 복사 붙여넣기
        Iterator<Element> i = elements.iterator();
        while (i.hasNext()) {
            // i.next() 를 사용한 로직
        }

         // 만약 i 를 i2로 변경하지 않더라도 컴파일 오류가 발생하지 않지만,
         // 추후 다른 문제 발생 가능성이 있다
        ArrayList<Element> elements2 = new ArrayList<>();
        Iterator<Element> i2 = elements2.iterator();
        while (i.hasNext()) {
            // i2.next() 를 사용한 로직
        }
    }

    // 예시3 : for 문 사용하면 복붙 에러 잡을 수 있다.
    public static void main3(String[] args) {
        ArrayList<Element> elements = new ArrayList<>();
        for (Iterator<Element> i = elements.iterator(); i.hasNext();) {
            Element e = i.next();
            // e 와 i 를 사용한 로직
        }

        /**
         * 변수 이름 잘못 입력해도 컴파일 오류로 잡을 수 있다
         */
//        ArrayList<Element> elements2 = new ArrayList<>();
//        for (Iterator<Element> i2 = elements2.iterator(); i.hasNext();) { // 컴파일 오류 발생
//            Element e = i2.next();
//            // e 와 i 를 사용한 로직
//        }
    }
}
