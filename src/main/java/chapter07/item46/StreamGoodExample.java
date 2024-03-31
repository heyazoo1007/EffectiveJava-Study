package chapter07.item46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

// 아이템46 : 스트림에서는 부작용 없는 함수를 사용하라
public class StreamGoodExample {
    // freq 에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
    Map<String, Long> freq = new HashMap<>();
    List<String> topTen = freq.keySet().stream()
            .sorted(comparing(freq::get).reversed()) // 내림차순 정렬
            .limit(10) // 상위 10개
            .collect(toList()); // 리스트 반환
}
