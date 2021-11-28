import java.util.ArrayList;

public class Phoketmon {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 3 };

        System.out.println(solution(nums));
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        ArrayList<Integer> pList = new ArrayList<>();

        for (int item : numbers) {
            if (!pList.contains(item)) {
                pList.add(item);
            }
        }

        if (pList.size() > numbers.length / 2) {
            answer = numbers.length / 2;
        } else {
            answer = pList.size();
        }

        return answer;
    }
}
