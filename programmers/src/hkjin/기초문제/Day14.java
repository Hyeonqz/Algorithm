package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;

public class Day14 {
	public static void main (String[] args) {
		Day14 day14 = new Day14();
		System.out.println();
	}

	/** 홀수 vs 짝수 */
	public int solution(int[] num_list) {
		int odd = 0;
		int even = 0;
		// num_list[0] 이 1번 원소라고 할 때
		// 홀수 번째 원소, 짝수 번째 원소 합 중 큰 값을 return 하는 값
		for (int i = 0; i <num_list.length ; i++) {
			if(i%2 == 0) {
				even += num_list[i];
			} else {
				odd += num_list[i];
			}
		}
		return Math.max(even, odd);
	}

	/** 5명씩 */
	public String[] solution(String[] names) {
		var list = new ArrayList<String>();

		for (int i = 0; i < names.length ; i+=5) {
			list.add(names[i]);
		}
		return list.toArray(String[]::new);
	}

	/** 할 일 목록 */
	public String[] solution(String[] todo_list, boolean[] finished) {
		// 아직 마치지 못한 일 = false, 순서대로 담은 문자열 배열을 return 하자
		var list = new ArrayList<String>();
		for (int i = 0; i < todo_list.length; i++) {

			if(!finished[i]) {
				list.add(todo_list[i]);
			}
		}
		return list.toArray(String[]::new);
	}

	/** n보다 커질 떄 까지 더하기 */
	public int solution(int[] numbers, int n) {
		int answer = 0;
		// numbers 의 원소를 앞에서 부터 하나씩 더하다가 N 보다 커지면 return
		for (int i = 0; i < numbers.length; i++) {
			answer += numbers[i];
			if(answer > n)
				break;
		}
		return answer;
	}

	/** 수열과 구간 쿼리1 */
	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr[i];
		}

		for (int i = 0; i < queries.length ; i++) {
			int s = queries[i][0];
			int e = queries[i][1];

			for (int j = s; j <= e ; j++) {
				answer[j] += 1;
			}
		}
		return answer;
	}
}
