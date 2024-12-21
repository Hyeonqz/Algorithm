package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {
	public static void main (String[] args) {
		Day6 day6 = new Day6();
	}
	/** 수열과 구간 쿼리2 */
	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];
		Arrays.fill(answer, -1);

		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];

			int minValue = Integer.MAX_VALUE; // 최소값을 저장할 변수, 일단 최대값으로 초기화합니다.

			for (int j = s; j <= e; j++) {
				if (arr[j] > k && arr[j] < minValue) {
					minValue = arr[j];
				}
			}

			if (minValue != Integer.MAX_VALUE) {
				answer[i] = minValue;
			}
		}

		return answer;
	}

	/** 수열과 구간 쿼리2 */
	public int[] solution3(int[] arr, int[][] queries) {

		for (int i = 0; i < queries.length ; i++) {
			int s = queries[i][0];
			int e = queries[i][1];

			int temp = arr[s];
			arr[s] = arr[e];
			arr[e] = temp;
		}

		return arr;
	}

	/** 마지막 두 원소 Level_0 */
	public int[] solution(int[] num_list) {
		List<Integer> list = new ArrayList<>();

		for(int i : num_list) {
			list.add(i);
		}

		int last = num_list[num_list.length - 1];
		int secondLast = num_list[num_list.length - 2];

		if (last > secondLast) {
			list.add(last - secondLast);
		} else {
			list.add(last * 2);
		}

		return list.stream().mapToInt(i->i).toArray();
	}

	/** 수 조작하기2 */
	public String solution2(int[] numLog) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < numLog.length; i++) {
			int diff = numLog[i] - numLog[i - 1];

			// 뒤에서 앞에꺼를 빼는거임. n[4] = n[4] - n[3]

			if (diff == 1) {
				sb.append("w");
			} else if (diff == -1) {
				sb.append("s");
			} else if (diff == 10) {
				sb.append("d");
			} else if (diff == -10) {
				sb.append("a");
			}
		}

		return sb.toString();
	}

	/** 수 조작하기1 */
	public int solution(int n, String control) {
		for (int i = 0; i <control.length() ; i++) {
			char c = control.charAt(i);
			if(c=='w')
				n +=1;
			if(c == 's')
				n -=1;
			if(c=='d')
				n+=10;
			if(c=='a')
				n-=10;
		}

		return n;
	}

}
