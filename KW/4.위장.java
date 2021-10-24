import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] clothes) {

        Function<String[], String> classifier = strings -> strings[1];

        Map<String, Long> result = Arrays.stream(clothes)
                .collect(Collectors.groupingByConcurrent(classifier,Collectors.counting()));

        return result.values().stream()
                .reduce(1L, (acc, curr) -> acc * (curr+1)).intValue()
                - 1;
    }
}