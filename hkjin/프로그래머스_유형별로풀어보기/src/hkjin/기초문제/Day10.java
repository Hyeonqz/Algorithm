package hkjin.기초문제;

public class Day10 {
	public static void main (String[] args) {

	}

	/** 문자열의 앞의 n글자 */
	public String solution(String my_string, int n) {
		return my_string.substring(0,n);
	}

	/** 접두사인지 확인하기 */
	public int solution(String my_string, String is_prefix) {
		int answer = 0;
		String[] arr = new String[my_string.length()];

		for (int i = 0; i <arr.length ; i++) {
			arr[i] = my_string.substring(0,i+1);
		}

		for(String str : arr) {
			if(str.equals(is_prefix))
				answer = 1;
		}

		return answer;
	}

	/** 문자열 뒤집기 */
	public String solution(String my_string, int s, int e) {
		StringBuilder sb = new StringBuilder(my_string.substring(s,e+1));
		sb.reverse();

		String old = my_string.substring(s, e+1);
		String new1 = sb.toString();

		return my_string.replaceAll(old, new1);

	}

	/** 세로 읽기 */
	public String solution1(String my_string, int m, int c) {
		StringBuilder sb = new StringBuilder();

		for (int i = c-1; i <my_string.length() ; i+=m) {
			sb.append(my_string.charAt(i));
		}
		return sb.toString();
	}

	/** qr code */
	public String solution(int q, int r, String code) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <code.length() ; i++) {
			if(i%q == r)
				sb.append(code.charAt(i));
		}

		return sb.toString();
	}
}
