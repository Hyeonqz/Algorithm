package hkjin.해시;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        // 솔루션: 중복 제거 + 카운팅 패턴

        Map<String, Set<String>> reporterMap = new HashMap<>();
        for (String id : id_list) {
            reporterMap.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] parts = r.split(" ");
            reporterMap.get(parts[0]).add(parts[1]);
        }

        Map<String, Integer> reportCount = new HashMap<>();
        for (String id : id_list) {
            reportCount.put(id, 0);
        }

        for (Set<String> reportedSet : reporterMap.values()) {
            for (String reportedId : reportedSet) {
                reportCount.put(reportedId, reportCount.get(reportedId)+1);
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];

            for (String reported : reporterMap.get(user)) {
                if (reportCount.get(reported) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
