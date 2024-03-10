package chapter07.item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class Lambda {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        words.sort(comparingInt(String::length));
    }
}
