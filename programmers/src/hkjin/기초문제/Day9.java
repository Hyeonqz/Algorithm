package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day9 {
	public static void main (String[] args) {

	}
	/** 배열 만들기5 */
	public int[] solution(String[] intStrs, int k, int s, int l) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < intStrs.length ; i++) {
			String str = intStrs[i].substring(s,s+l);
			int b = Integer.parseInt(str);
			if(b>k)
				list.add(b);
		}

		int[] newArr = new int[list.size()];

		for (int i = 0; i <list.size() ; i++) {
			newArr[i] = list.get(i);
		}

		return newArr;
	}

	/** 부분 문자열 이어 붙여 문자열 만들기 */
	public String solution(String[] my_strings, int[][] parts) {
		StringBuilder sb= new StringBuilder();
		// 2차원 parts 배열은, myStrings 의 인덱스 s~e 의미함

		for (int i = 0; i <my_strings.length ; i++) {
			int s = parts[i][0];
			int e = parts[i][1];

			String sub = my_strings[i].substring(s,e+1);
			sb.append(sub);
		}

		return sb.toString();
	}

	/** 문자열 뒤의 n글자 */
	public String solution(String my_string, int n) {
		int len = my_string.length() - n;

		return my_string.substring(len, len+n);
	}

	/** 접미사 배열 */
	public String[] solution(String my_string) {

		String[] suffixes = new String[my_string.length()];
		for (int i = 0; i < my_string.length(); i++) {
			suffixes[i] = my_string.substring(i);
		}

		Arrays.sort(suffixes);

		return suffixes;
	}

	/** 접미사인지 확인하기 */
	public int solution(String my_string, String is_suffix) {
		int answer = 0;
		String[] arr =new String[my_string.length()];

		for (int i = 0; i <arr.length ; i++) {
			arr[i] = my_string.substring(i);
		}

		Arrays.sort(arr);

		for (int i = 0; i <arr.length ; i++) {
			if(arr[i].equals(is_suffix)) {
				answer = 1;
			}
		}
		return answer;
	}
}
