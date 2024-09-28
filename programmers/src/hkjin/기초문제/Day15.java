package hkjin.기초문제;

import java.math.BigInteger;
import java.util.Arrays;

public class Day15 {
	public static void main (String[] args) {
		Day15 day15 = new Day15();
		System.out.println(Arrays.toString(day15.solution(new int[] {1, 2, 3, 100, 99, 98})));

	}

	/** 원하는 문자열 찾기 */
	public int solution(String myString, String pat) {
		int answer = 0;
		String lowerCase = myString.toLowerCase();
		String patLowerCase = pat.toLowerCase();

		patLowerCase.indexOf(lowerCase);

		return lowerCase.contains(patLowerCase)? 1:0;
	}

	/** 길이에 따른 연산 */
	public int solution3(int[] num_list) {
		int answer = (num_list.length < 11 ? 1 : 0);

		if(num_list.length >= 11) {
			for (int i = 0; i < num_list.length; i++) {
				answer += num_list[i];
			}
		} else {
			for (int j = 0; j < num_list.length; j++) {
				answer = answer * num_list[j];
			}
		}

		return answer;
	}

	/** 조건에 맞게 수열 변환하기1 */
	public int[] solution(int[] arr) {
		int[] answer = new int[arr.length];

		for (int i = 0; i < answer.length; i++) {
			if(arr[i] >= 50 && arr[i]%2!=1) {
				answer[i] = arr[i]/2;
			} else if(arr[i] < 50 && arr[i]%2==1){
				answer[i] = arr[i]*2;
			} else {
				answer[i] = arr[i];
			}
		}
		return answer;
	}

	/** 조건에 맞게 수열 변환하기2 */
	public int solution1(int[] arr) {
		int answer = 0;
		int[] newArr = Arrays.copyOf(arr, arr.length);
		int[] resultArr = Arrays.copyOf(arr, arr.length);

		while (true) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= 50 && arr[i] % 2 == 0) {
					newArr[i] = arr[i] / 2;
				} else if (arr[i] < 50 && arr[i] % 2 == 1) {
					newArr[i] = (arr[i] * 2) + 1;
				} else {
					newArr[i] = arr[i];
				}

				if (Arrays.equals(resultArr, newArr)) {
					answer = i;
					break;
				}
				resultArr = Arrays.copyOf(newArr, newArr.length);
			}
			return answer;
		}
	}

	/** 1로 만들기 -> 살짝 어려웠음 */
	public int solution2(int[] num_list) {
		int answer = 0;

		// 각 숫자에 대해 필요한 연산 횟수를 계산
		for (int i = 0; i < num_list.length; i++) {
			answer += method(num_list[i]);
		}

		return answer;
	}

	private int method(int num) {
		int count = 0;

		// 숫자가 1이 될 때까지 반복
		while (num > 1) {
			if (num % 2 == 0) {
				num /= 2;  // 짝수는 2로 나눔
			} else {
				num = (num - 1) / 2;  // 홀수는 1을 뺀 후 2로 나눔
			}
			count++;  // 연산 횟수 증가
		}

		return count;
	}



}
