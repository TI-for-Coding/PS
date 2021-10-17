package BeakJoon;

import java.io.*;
import java.util.Arrays;
/**
 * 백준 코딩 2170 번 선긋기 
 * 시간 초과 발생. 구글 검색시 Scanner 클래스 사용해서라고 하여 BufferedReader로 변경하였으나 여전히 시간 초과 발생
 * 소스에 개선할 부분이 있으면 코멘트 부탁드립니다 ㅠㅠ
 * 구글링을 해보니 이 알고리즘 문제는 Sweeping 기법을 사용한다고 하네요.. 관련 기법도 공부 하도록 하겠습니다
 */
public class A2170 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[][] xyList; // 좌표 리스트
        String xyValue; 
        int totLength = 0;
        int numOfLines = 0;

        System.out.print("선의 수: ");
        numOfLines = Integer.parseInt(input.readLine());

        xyList = new int[numOfLines][2];

        for (int i = 0; i < numOfLines; i++) {
            System.out.print("좌표: ");
            xyValue = input.readLine();
            xyList[i][0] = Integer.parseInt(xyValue.split("\\s")[0]);
            xyList[i][1] = Integer.parseInt(xyValue.split("\\s")[1]);
        }

        // 2차원 배열 오름차순 정리
        Arrays.sort(xyList, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return Integer.compare(a1[1], a2[1]);
            } else {
                return Integer.compare(a1[0], a2[0]);
            }
        });

        int xValue = xyList[0][0];
        int yValue = xyList[0][1];
        totLength = yValue - xValue;

        // 위에서 2차월 배열 오름차순 정리를 했기 때문에
        // 왼쪽부터 좌표를 확인하며 진행 (Sweeping)
        for (int i = 1; i < numOfLines; i++) {
            
            if(xValue <= xyList[i][0] && xyList[i][1] <= yValue) {
                continue;
            } else if (xyList[i][0] <= yValue) {
                totLength += xyList[i][1] - yValue;
            } else if (xValue <= xyList[i][0]) {
                totLength += xyList[i][1] - xyList[i][0];
            }

            xValue = xyList[i][0];
            yValue = xyList[i][1];
        }

        System.out.println(totLength);
    }
}
