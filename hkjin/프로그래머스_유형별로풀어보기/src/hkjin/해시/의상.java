package hkjin.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();


        // [1] 의상 이름, 의상 종류 put
        for (String[] clothe : clothes) {
            String category = clothe[1];

            map.put(category, map.getOrDefault(category, 0) +1);
        }

        // [2] 조합 구하기 (각 카테고리 (개수 + 1) 을 전부 곱한다.
        int answer = 1;
        for (int count : map.values()) {
            answer *= count+1;
        }

        return answer -1;
    }
}
