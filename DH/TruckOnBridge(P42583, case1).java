/* 작성일 : 2021.10.06
** 언어 : Java
** 출처 : 프로그래머스 [코딩테스트 연습>스택/큐>다리를 지나는 트럭]
** 메모 : 자바의 ArrayList를 활용한 Queue 구현. 
         ArrayList에 특정 상수를 전체 더하는 addList(),
         ArrayList를 전체 합산하는 sumList() 메소드를 선언하였음.
         추후 Queue 자료형을 이용한 문제풀이를 해볼 예정입니다.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        List <Integer> truck_weight_list = new ArrayList<Integer>();
        List <Integer> truck_ops_weights = new ArrayList<Integer>();
        List <Integer> truck_ops_time = new ArrayList<Integer>();
        
        for (int i = 0; i < truck_weights.length; i++) {
            truck_weight_list.add(truck_weights[i]);
        }
        
        while (true) {
            
            answer++;
            
            if (truck_ops_weights.size() != 0) {
                if(truck_ops_time.get(0) >= bridge_length) {
                    truck_ops_weights.remove(0);
                    truck_ops_time.remove(0);
                }
            }
            
            if (truck_weight_list.size() != 0) {
                if (sumList(truck_ops_weights) + truck_weight_list.get(0) <= weight) {
                    truck_ops_weights.add(truck_weight_list.get(0));
                    truck_weight_list.remove(0);
                    truck_ops_time.add(0);
                    }
                }
            
            addList(truck_ops_time, 1);
             
            if ((truck_ops_weights.size() == 0)&&(truck_weight_list.size() == 0)) {
                break;
            }
            
        }
        
        return answer;
    }
    
    public static void addList (List <Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            list.add(list.get(0) + value);
            list.remove(0);
        }
    }
    
    public static int sumList (List <Integer> list) {
        
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }
        
        return result;
    }
    
}
