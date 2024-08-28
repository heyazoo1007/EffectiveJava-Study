package chapter12.item89;

import java.io.Serializable;
import java.util.Arrays;

// 아이템89 : 인스턴스 수를 통제해야 한다면 readResolve보다는 열거 타입을 사용하라
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    private String[] favoriteSongs = { "Hound Dog", "HeartBreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
