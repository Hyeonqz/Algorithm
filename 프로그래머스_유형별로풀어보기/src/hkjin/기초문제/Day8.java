package hkjin.기초문제;

public class Day8 {
	public static void main (String[] args) {
		Day8 day8 = new Day8();
		System.out.println(day8.solution("rermgorpsam", new int[][] {{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
	}

	/** 간단한 논리 연산 */
	public boolean solution (boolean x1, boolean x2, boolean x3, boolean x4) {
		if ((x1 || x2) && (x3 || x4))
			return true;
		else
			return false;
	}

	/** 주사위 게임 3 */
	public int solution (int a, int b, int c, int d) {
		// 모든 주사위 값이 같은 경우
		if (a == b && b == c && c == d) {
			return 1111 * a;
		}

		// 세 개가 같고 하나가 다른 경우
		if (a == b && b == c && c != d) {
			return (int)Math.pow(10 * a + d, 2);
		}
		if (a == b && b == d && d != c) {
			return (int)Math.pow(10 * a + c, 2);
		}
		if (a == c && c == d && d != b) {
			return (int)Math.pow(10 * a + b, 2);
		}
		if (b == c && c == d && d != a) {
			return (int)Math.pow(10 * b + a, 2);
		}

		// 두 개씩 같은 경우
		if (a == b && c == d && a != c) {
			return (a + c) * Math.abs(a - c);
		}

		if (a == c && b == d && a != b) {
			return (a + b) * Math.abs(a - b);
		}

		if (a == d && b == c && a != c) {
			return (a + b) * Math.abs(a - c);
		}

		// 두 개만 같고 나머지 두 개가 다른 경우
		if (a == b && c != d && a != c && a != d) {
			return c * d;
		}
		if (a == c && b != d && a != b && a != d) {
			return b * d;
		}
		if (a == d && b != c && a != b && a != c) {
			return b * c;
		}
		if (b == c && a != d && b != a && b != d) {
			return a * d;
		}
		if (b == d && a != c && b != a && b != c) {
			return a * c;
		}
		if (c == d && a != b && c != a && c != b) {
			return a * b;
		}

		// 네 숫자가 모두 다른 경우
		if (a != b && a != c && a != d && b != c && b != d && c != d) {
			return Math.min(Math.min(a, b), Math.min(c, d));
		}

		return 0; // 기본 반환값 (필요에 따라 수정 가능)
	}

	/** 글자 이어 붙여 문자열 만들기 */
	public String solution (String my_string, int[] index_list) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < index_list.length; i++) {
			sb.append(my_string.charAt(index_list[i]));
		}

		return sb.toString();
	}

	/** 9로 나눈 나머지 */
	public int solution (String number) {
		int result = 0;
		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			result += Integer.parseInt(String.valueOf(c));
		}
		return result % 9;
	}

	/** 문자열 여러 번 뒤집기 */
	public String solution (String my_string, int[][] queries) {
		char[] arr = my_string.toCharArray();

		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];

			while (s<e) {
				// 교환 방식은 임시 저장소가 꼭 필요하다.
				char tmp = arr[s];
				arr[s] = arr[e];
				arr[e] = tmp;
				s++;
				e--;
			}
		}

		return new String(arr);
	}

}
