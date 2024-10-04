package hkjin.기초문제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Day23 {
	public static void main (String[] args) {

	}

	// Day23 조건문 활용

	/** 부분 문자열 */
	public int solution(String str1, String str2) {
		return str2.contains(str1) ? 1 : 0;
	}

	/** 꼬리 문자열 */
	public String solution(String[] str_list, String ex) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <str_list.length ; i++) {
			if(str_list[i].contains(ex)) {
				continue;
			} else {
				sb.append(str_list[i]);
			}
		}

		return sb.toString();
	}

	/** 정수 찾기 */
	public int solution(int[] num_list, int n) {
		return IntStream.of(num_list).anyMatch(i -> i == n) ? 1 : 0;
	}

	/** 주사위 게임1 */
	public int solution(int a, int b) {
		if(a % 2 == 1 && b % 2 == 1) {
			return (int)(Math.pow(a,2) + Math.pow(b,2));
		}
		if(a % 2 == 1 || b % 2 == 1) {
			return 2 * (a+b);
		} else {

			return Math.abs(a-b);
		}
	}

	/** 날짜 비교하기 */
	public int solution(int[] date1, int[] date2) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		for (int i = 0; i <date1.length ; i++) {
			sb.append(date1[i]);
			sb2.append(date2[i]);
		}

		int a = Integer.parseInt(sb.toString());
		int b = Integer.parseInt(sb2.toString());

		return a > b ? 0 : 1;
	}
}
