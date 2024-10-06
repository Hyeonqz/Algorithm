package hkjin.기초문제;

public class Solution {
	private Solution () {
	}

	public static void main (String[] args) {
		Solution solution = new Solution();
	}
	public int 더크게합치기 (int a, int b) {
		int answer = 0;
		int aLong = Integer.parseInt("" + a + b);
		int bLong = Integer.parseInt("" + b + a);
		answer = Math.max(aLong, bLong);

		return answer;
	}

	public int 두수의연산값비교하기 (int a, int b) {
		return Math.max(Integer.parseInt(String.valueOf(a) + String.valueOf(b)), 2 * a * b);
	}

	public int 공배수 (int number, int n, int m) {
		return number % n == 0 && number % m == 0 ? 1 : 0;
	}

	public int 홀짝에따다른값반환하기(int n) {
		int answer = 0;

		if(n%2==1) {
			for(int i=0; i<=n; i++) {
				answer += i%2 ==1 ? i : 0;
			}
		}

		if(n%2==0) {
			for(int i=0; i<=n; i++) {
				answer += i % 2 == 0 ? i*i : 0;
			}
		}

		return answer;
	}

	public int 조건문자열(String ineq, String eq, int n, int m) {
		boolean result = false;
		int answer = 0;

		if(ineq.equals("<")) {
			if(eq.equals("=")) {
				result = n <=m;
			} else {
				result = n < m;
			}
		}

		if(ineq.equals(">")) {
			if(eq.equals("=")) {
				result = n>=m;
			} else {
				result = n>m;
			}
		}

		return result ? 1:0;
	}

	public int flat_따라다른값반환(int a, int b, boolean flag) {
		return flag ? a+b : a-b;
	}

}