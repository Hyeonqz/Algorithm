package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Day20 {
	public static void main (String[] args) {

	}
	/**  Day20 - 함수(메소드) */
	public int[] solution(int[] arr) {
		int len = arr.length;
		int count = 1;

		while(count < len) {
			count *= 2;
		}

		if(len == count)
			return arr;

		int[] answer = new int[count];
		for (int i = 0; i < len; i++) {
			answer[i] = arr[i];
		}

		return answer;
	}

	/** 배열 비교하기 */
	public int solution(int[] arr1, int[] arr2) {
		// 두 배열의 길이가 다르면, 배열의 길이가 긴 쪽이 더 크다.
		// 배열의 길이가 같다면, 각 배열에 있는 모든 원소의 합을 비교하여 다르다면 더 큰쪽이 크고, 같다면 같다.
		// arr1 < arr2 -> -1, arr > arr2 -> 1, arr == arr2 -> 0
		if(arr1.length < arr2.length)
			return -1;

		if(arr1.length >  arr2.length)
			return 1;

		int a = 0;
		int b = 0;

		for (int i = 0; i < arr1.length ; i++) {
			a+= arr1[i];
			b+= arr2[i];
		}

		// 삼항 연산자로 고쳤으면 좋았을 듯?
		if(arr1.length == arr2.length) {
			if(a>b)
				return 1;
			if(a<b)
				return -1;
		}
		return 0;
	}

	/** 문자열 묶기 */
	public int solution(String[] strArr) {
		int[] lengthCount = new int[31];

		// 아래 로직을 통해, 갯수만 센다.
		for(String str : strArr) {
			int len = str.length();
			lengthCount[len]++;
		}

		return Arrays.stream(lengthCount).max().getAsInt();
	}

	/** 배열의 길이에 따라 다른 연산하기 */
	public int[] solution(int[] arr, int n) {
		int[] answer = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if(arr.length % 2 ==0 ) {
				if(i % 2 == 0) {
					answer[i] = arr[i];
				} else {
					answer[i] = arr[i] + n;
				}
			} else {
				if(i%2 ==1) {
					answer[i] = arr[i];
				} else {
					answer[i] = arr[i] + n;
				}
			}
		}
		return answer;
	}

	/** 뒤에서 5등까지 */
	public int[] solution1(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOfRange(num_list,0,5);
	}

}
