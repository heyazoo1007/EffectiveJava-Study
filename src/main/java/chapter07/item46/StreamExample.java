package chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

// 아이템46 : 스트림에서는 부작용 없는 함수를 사용하라
public class StreamExample {

    // BAD CASE -> freq 를 직접 수정하기 때문에 스트림 API 의 이점이 없고, 가독성과 유지보수에 좋지 않다.
    public static void main(String[] args) {
        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(new File("pathname")).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
