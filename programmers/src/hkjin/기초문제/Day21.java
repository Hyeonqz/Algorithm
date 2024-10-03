package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Day21 {
	public static void main (String[] args) {

	}

	// Day21 함수(메소드)

	/** 뒤에서 5등 위로 */
	public int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOfRange(num_list, 5, num_list.length);
	}

	/** 전국 대회 선발 고사 */
	public int solution(int[] rank, boolean[] attendance) {
		var list =  new ArrayList<Integer>();

		for (int i = 0; i < rank.length ; i++) {
			if(attendance[i]) {
				list.add(i);
			}
		}

		list.sort(Comparator.comparingInt(a -> rank[a]));

		return 10000*list.get(0) + 100*list.get(1) + list.get(2);
	}

	/** 정수 부분 */
	public int solution(double flo) {
		String a = String.valueOf(flo);
		String[] answer = a.split("\\.");
		String b = answer[0];
		return Integer.parseInt(b);
	}

	/** 문자열 정수의 합 */
	public int solution(String num_str) {
		int sum = 0;
		for (int i = 0; i < num_str.length(); i++) {
			char c = num_str.charAt(i);
			sum += Integer.parseInt(String.valueOf(c));
		}
		return sum;
	}

	/** 문자열을 정수로 변환하기 */
	public int solution1(String n_str) {
		return Integer.parseInt(n_str);
	}
}
