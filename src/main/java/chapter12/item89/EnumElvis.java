package chapter12.item89;

import java.util.Arrays;

public enum EnumElvis {
    INSTANCE;

    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorite() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
