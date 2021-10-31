package DFS;

/**
 * 타켓 넘버 문제는 DFS 알고리즘 공부 후 풀이를 참조하였습니다. [참조] https://fbtmdwhd33.tistory.com/237
 * 
 * DFS 깊이 우선 탐색 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에 해당 분기를 완벽하게
 * 탐색하는 방법 모든 경우의 수를 확인하고자 하는 경우 이 방법을 선택해서 문제를 해결할 수 있음 알고리즘 자체는 BFS (너비우선탐색)보다
 * 간단하나, 속도는 느림
 * 
 * DFS는 자기 자신을 호출하는 순환 알고리즘의 형태를 가지고 있음 어떤 노드를 방문했었는지 여부를 반드시 검사하여야 함. 그렇지 않을 경우
 * 무한루프에 빠질 수 있음. 일반적으로 재귀호출을 사용하여 구현
 */
public class TargetNumber {
    static int answer = 0;

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(solution(nums, target));
    }

    // numbers, target, 진행중인index, index까지 진행했을 때 sum 값
    public static void dfs(int[] numbers, int target, int index, int sum) {
        // 끝까지 탐색 완료시
        if (index == numbers.length) {
            // sum 값과 타겟이 같을 경우 answer++;
            if (sum == target) {
                answer++;
            }
            // 무한 루프 방지를 위해 탐색 완료시 return 종료
            return;
        }

        // 인덱스에 값을 더함
        sum += numbers[index];
        // 다음 탐색 진행
        dfs(numbers, target, index + 1, sum);

        // 인덱스에 값을 뺌 (해당 index의 원래 sum값으로 맞춰줌)
        sum -= numbers[index];
        // 인덱스에서 값을 뺌
        sum += -1 * numbers[index];
        // 다음 탐색 진행
        dfs(numbers, target, index + 1, sum);

    }

    public static int solution(int[] numbers, int target) {
        answer = 0;

        // numbers, target, index, sum
        dfs(numbers, target, 0, 0);

        return answer;
    }
}
