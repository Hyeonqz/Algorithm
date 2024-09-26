package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {
	public static void main (String[] args) {

	}
	/** 가까운 1 찾기 */
	public int solution(int[] arr, int idx) {
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			if(i >= idx && arr[i] == 1) {
				answer = arr[i];
				break;
			} else {
				answer = -1;
			}
		}

		return answer;
	}

	/** 카운트 다운 */
	public int[] solution1(int start_num, int end_num) {
		int[] answer = new int[start_num-end_num+1];
		for (int i = 0; i <answer.length ; i++) {
			answer[i] = start_num--;
		}
		return answer;
	}

	/** 문자 개수 세기 */
	public int[] solution(String my_string) {
		int[] answer = new int[52];

		for (int i = 0; i < my_string.length(); i++) {
			char c = my_string.charAt(i);
			// 'A' = 65, 'a' = 97

			if(c >= 'A' && c <= 'Z') {
				answer[c - 'A']++;
			} else if (c >= 'a' && c <= 'z') {
				answer[26 + c  - 'a']++;
			}
		}
		return answer;
	}

	/** 배열 만들기 1 */
	public int[] solution(int n, int k) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n ; i++) {
			if(k*(i+1) <= n) {
				list.add(k*(i+1));
			}
			else {
				break;
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 글자 지우기 */
	public String solution(String my_string, int[] indices) {
		StringBuilder sb = new StringBuilder();
		List<Character> list = new ArrayList<>();

		Arrays.sort(indices);

		for(char c :my_string.toCharArray()) {
			list.add(c);
		}

		for (int i = indices.length-1; i >= 0 ; i--) {
			list.remove(indices[i]);
		}

		for (char c: list) {
			sb.append(c);
		}

		return sb.toString();
	}
}
