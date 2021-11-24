import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(comparator)
                .reduce("", String::concat)
                .replaceAll("^0+(?!$)", "");
    }

    private Comparator<String> comparator = (str1, str2) -> {
        if (str1.length() != str2.length()){
            String tmp = str2;
            str2 += str1;
            str1 += tmp;
        }
        return -str1.compareTo(str2);
    };
}