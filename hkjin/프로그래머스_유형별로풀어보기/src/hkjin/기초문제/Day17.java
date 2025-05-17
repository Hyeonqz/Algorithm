package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Day17 {
	public static void main (String[] args) {
		String a = "    abcd   love    you";
		System.out.println(a.trim());
		String[] b = a.trim().split("\\s");
		String[] c = a.trim().split("\\s+");
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}

	/** 공백으로 구분하기1 */
	public String[] solution(String my_string) {
		String[] answer = my_string.split(" ");
		return answer;
	}

	/** 공백으로 구분하기2 */
	public String[] solution2(String my_string) {

		my_string = my_string.trim();

		StringTokenizer st = new StringTokenizer(my_string);

		ArrayList<String> wordList = new ArrayList<>();

		while (st.hasMoreTokens()) {
			wordList.add(st.nextToken());
		}

		return wordList.toArray(new String[0]);
	}

	/** 공백으로 구분하기2 best-practice */
	private String[] solution3(String my_string) {
		return my_string.trim().split(" ");
	}

	/** ad 제거하기 */
	public String[] solution(String[] strArr) {
		String[] temp = new String[strArr.length];
		int count = 0;

		for (int i = 0; i < strArr.length; i++) {
			if (!strArr[i].contains("ad")) {
				temp[count] = strArr[i];
				count++;
			}
		}

		String[] result = new String[count];

		for (int i = 0; i <count ; i++) {
			result[i] = temp[i];
		}

		return result;
	}
	/** ad 제거하기 best-practice */
	private String[] solution2(String[] strArr) {
		return Arrays.stream(strArr).filter(s -> !s.contains("ad")).toArray(String[]::new);
	}

	/** 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기 */
	public String solution(String myString, String pat) {
		String[] arr = myString.split("");
		arr = Arrays.copyOfRange(arr, 0, myString.lastIndexOf(pat) + pat.length());
		return String.join("", arr);
	}

	/** 문자열이 몇 번 등장하는지 세기 */
	public int solution1(String myString, String pat) {
		int count = 0;
		int patLength = pat.length();

		for (int i = 0; i <= myString.length() - patLength; i++) {
			if(myString.substring(i, i+patLength).equals(pat))
				count++;
		}

		return count;
	}
}
