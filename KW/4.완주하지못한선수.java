import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(participant)
                .collect(
                        Collectors.groupingBy(String::valueOf, Collectors.counting())
                );
        Arrays.stream(completion).forEach(p -> {
            long curr = map.get(p) - 1;
            if(curr == 0) map.remove(p);
            else map.replace(p, curr);
        });
        return map.keySet().stream().findFirst().orElseThrow();
    }
}