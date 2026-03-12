package hkjin.해시;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c)-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return "";
    }

}
