package hkjin.기초문제;

public class Day16 {
	public static void main (String[] args) {

	}

	/** 특정한 문자 대문자로 바꾸기 */
	public String solution(String my_string, String alp) {
		return my_string.replace(alp, alp.toUpperCase());
	}

	/** A 강조하기 */
	public String solution2(String myString) {
		StringBuilder sb = new StringBuilder();
		String lowerCase = myString.toLowerCase();

		for(int i=0; i<lowerCase.length(); i++) {
			char c = lowerCase.charAt(i);
			if(c == 'a') {
				String up = String.valueOf(c).toUpperCase();
				sb.append(up);
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/** 배열에서 문자열 대소문자 변환하기 */
	public String[] solution(String[] strArr) {
		String[] answer = new String[strArr.length];
		// 홀수 대문자, 짝수 소문
		for (int i = 0; i < strArr.length; i++) {
			if(i%2==0) {
				answer[i] = strArr[i].toLowerCase();
			} else {
				answer[i] = strArr[i].toUpperCase();
			}
		}
		return answer;
	}

	/** 대문자로 바꾸기 */
	public String solution(String myString) {
		return myString.toUpperCase();
	}

	/** 소문자로 바꾸기 */
	public String solution1(String myString) {
		return myString.toLowerCase();
	}


}
