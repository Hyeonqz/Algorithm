package hkjin.스택_큐;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        // [1] 각 작업의 완료 일수 계산
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }

        // [2] 그룹핑 - 앞 작업 기준으로 묶기
        List<Integer> result = new ArrayList<>();
        int leader = days[0];
        int count = 1;

        for (int i = 1; i < days.length; i++) {
            if (days[i] <= leader) {
                count++;
            } else {
                result.add(count);
                leader = days[i];
                count = 1;
            }
        }
        result.add(count);  // 마지막 그룹 저장 잊지 말 것

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
