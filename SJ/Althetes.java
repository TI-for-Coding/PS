package HashMap;

import java.util.HashMap;

public class Athletes {
    public static void main(String[] args) {
        String[] p = { "leo", "kiki", "eden" };
        String[] c = { "eden", "kiki" };
        solution(p, c);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> pMap = new HashMap<String, Integer>();

        for (String pKey : participant) {
            pMap.put(pKey, pMap.getOrDefault(pKey, 0) + 1);
        }

        for (String cKey : completion) {
            pMap.put(cKey, pMap.get(cKey) - 1);
        }

        for (String pKey : pMap.keySet()) {
            if (pMap.get(pKey) > 0) {
                answer = pKey;
                break;
            }
        }

        return answer;
    }
}

/**
 * 아래 오답, 위는 블로그 풀이 참조
 * https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%9C-%EC%84%A0%EC%88%98-%ED%95%B4%EC%8B%9C-Lv-1
 * 
 * import java.util.HashMap;
 * 
 * class Solution { public String solution(String[] participant, String[]
 * completion) { String answer = ""; HashMap<String, Integer> pMap = new
 * HashMap<String, Integer>(); HashMap<String, Integer> cMap = new
 * HashMap<String, Integer>(); // for(String key : alphabet) hm.put(key,
 * hm.getOrDefault(key, 0) + 1);
 * 
 * for (String pKey : participant) { pMap.put(pKey, pMap.getOrDefault(pKey, 0) +
 * 1); }
 * 
 * for (String cKey : completion) { cMap.put(cKey, cMap.getOrDefault(cKey, 0) +
 * 1); }
 * 
 * for (String pKey : pMap.keySet()) { for (String cKey : cMap.keySet()) { if
 * (cKey.equals(pKey)) { pMap.put(pKey, pMap.get(pKey) - 1); } } }
 * 
 * for (String pKey : pMap.keySet()) { if (pMap.get(pKey) > 0) { answer = pKey;
 * break; } }
 * 
 * return answer; } }*
 * 
 */
