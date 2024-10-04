package hkjin.기초문제;

import java.util.ArrayList;

public class Day24 {
	public static void main (String[] args) {
		Day24 day24 = new Day24();
	}

	// Day24 조건문 활용, 반복문 활용, 이차원 리스트(배열)

	/** 커피 심부름 */
	public int solution(String[] order) {
		String americano = "americano";
		String cafeLatte = "cafelatte";

		int americanoCount = 0;
		int cafeLatteCount = 0;

		for (int i = 0; i < order.length ; i++) {
			if(order[i].contains(americano)) {
				americanoCount++;
				continue;
			}
			if(order[i].contains(cafeLatte)) {
				cafeLatteCount++;
				continue;
			} else {
				americanoCount++;
			}

		}

		return americanoCount * 4500 + cafeLatteCount * 5000;
	}

	/** 그림 확대 */
	public String[] solution(String[] picture, int k) {
		var list = new ArrayList<String>();

		for(String row : picture) {
			StringBuilder sb = new StringBuilder();
			for(char c : row.toCharArray()) {
				sb.append(String.valueOf(c).repeat(k));
			}

			for(int i=0; i < k; i++) {
				list.add(sb.toString());
			}
		}
		return list.toArray(new String[0]);
	}

	/** 조건에 맞게 수열 변환하기 3 */
	public int[] solution(int[] arr, int k) {
		int[] answer = new int[arr.length];

		if(k % 2 == 1) {
			for (int i = 0; i < answer.length ; i++) {
				answer[i] = arr[i] * k;
			}
		} else {
			for (int i = 0; i < answer.length ; i++) {
				answer[i] = arr[i] + k;
			}
		}

		return answer;
	}

	/** l 로 만들기 */
	public String solution(String myString) {
		StringBuilder sb = new StringBuilder();

		final char c = 'l';

		for (int i = 0; i <myString.length() ; i++) {
			if(myString.charAt(i) < c) {
				sb.append(c);
				continue;
			} else {
				sb.append(myString.charAt(i));
			}
		}
		return sb.toString();
	}

	/** 특별한 이차원 배열1 */
	public int[][] solution(int n) {
		int[][] answer = new int[n][n];

		for (int i = 0; i < n; i++) {
			answer[i][i] = 1;
		}

		return answer;
	}
}
