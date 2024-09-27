package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
	/*
	 * a ~ b 까지, 즉 범위에 대한 문제가 나오면 Arrays.copyOfRange() 를 자주 사용하면 좋을듯
	 *  Arrays.copyOfRange(원본배열, 시작 인덱스, 마지막 인덱스)
	 *  ** 마지막 인덱스는 -1 한 값 까지 복사를 한다.
	 * */

	/** n 번째 원소부터 */
	public int[] solution(int[] num_list, int n) {
		int[] result = new int[num_list.length - n + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = num_list[n - 1 + i];
		}
		return result;
	}

	/** 순서 바꾸기 */
	public int[] solution1(int[] num_list, int n) {
		int[] answer = new int[num_list.length];
		int index = 0;

		for (int i = n; i < num_list.length; i++) {
			answer[index++] = num_list[i];
		}

		for (int i = 0; i < n; i++) {
			answer[index++] = num_list[i];
		}

		return answer;
	}

	/** 왼쪽 오른쪽 */
	public String[] solution(String[] str_list) {
		String[] answer = {};

		for (int i = 0; i < str_list.length; i++) {
			switch (str_list[i]) {
				case "l" -> {
					return Arrays.copyOfRange(str_list, 0, i);
				}
				case "r" -> {
					return Arrays.copyOfRange(str_list, i + 1, str_list.length);
				}
			}
		}
		return answer;
	}

	/** n 번째 원소까지 */
	public int[] solution2(int[] num_list, int n) {
		var list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			list.add(num_list[i]);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** n개 간격의 원소들 */
	public int[] solution3(int[] num_list, int n) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i <= num_list.length ; i+=n) {
			list.add(num_list[i]);
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
