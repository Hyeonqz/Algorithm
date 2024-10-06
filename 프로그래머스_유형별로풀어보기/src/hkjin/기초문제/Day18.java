package hkjin.기초문제;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Day18 {
	public static void main (String[] args) {

	}

	/** x 사이의 개수 */
	public int[] solution(String myString) {
		int[] answer = {};

		String[] arr = myString.split("x",-1);
		answer = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i].length();
		}

		return answer;
	}
	private int[] bestPractice1(String myString) {
		return Arrays.stream(myString.split("x", myString.length()))
			.mapToInt(String::length)
			.toArray();
	}

	/** 문자열 잘라서 정렬하기 (살짝 어려웠음..테스트 케이스 떄문에) */
	public String[] solution1(String myString) {
		return Arrays.stream(myString.split("x"))
			.filter(s -> !s.isEmpty())
			.sorted()
			.toArray(String[]::new);
	}

	/** 간단한 식 계산하기 */
	public int solution2(String binomial) {
		int answer = 0;
		String[] arr = binomial.trim().split(" ");

		int a = Integer.parseInt(arr[0]);
		String s = arr[1];
		int b = Integer.parseInt(arr[2]);

		if(s.equals("+")) {
			answer = a+b;
		} else if(s.equals("-")) {
			answer = a-b;
		} else {
			answer = a*b;
		}

		return answer;
	}

	/** 문장졀 바꿔서 찾기 */
	public int solution(String myString, String pat) {
		String[] arr= myString.split("");
		for (int i = 0; i <myString.length() ; i++) {
			if(arr[i].equals("A")) {
				arr[i] = arr[i].replace("A","B");
			} else {
				arr[i] = arr[i].replace("B","A");
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length ; i++) {
			sb.append(arr[i]);
		}

		if(sb.toString().contains(pat)) {
			return 1;
		} else {
			return 0;
		}
	}

	/** my_String */
	public String solution3(String rny_string) {
		return rny_string.replace("m","rn");
	}
}
