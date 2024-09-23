package hkjin.기초문제;

public class Day5 {
	public static void main (String[] args) {
		Day5 day5 = new Day5();
	}
		/** 이어 붙인 수 Level_0 */
		public int solution1(int[] num_list) {
			StringBuilder even = new StringBuilder();
			StringBuilder odd = new StringBuilder();

			for (int i = 0; i <num_list.length ; i++) {
				if(num_list[i] % 2 == 1)
					odd.append(num_list[i]);
				else
					even.append(num_list[i]);
			}

			int result1 = Integer.parseInt(even.toString());
			int result2 = Integer.parseInt(odd.toString());

			return result1+result2;
		}

		/** 원소들의 곱과함 Level_0 */
		public int solution(int[] num_list) {
			// 모든 원소들의 곱이
			// 모든 원소들의 합의 제곱보다 작으면 1, 크면 0
			int result1 = 0;
			for (int i = 0; i <num_list.length ; i++) {
				result1 += num_list[i];
			}

			double plusPow = Math.pow(result1,2);

			double result2 = 1;
			for (int i = 0; i <num_list.length ; i++) {
				result2 *= num_list[i];
			}

			return result2 < plusPow ? 1 : 0;
		}

		/** 주사위 게임2 Level_0 */
		public int solution(int a, int b, int c) {

			int result1 = a+b+c;
			int result2 = (int)((a+b+c) * (Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2)));
			int result3 = (int)((a+b+c) * (Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2)) * (Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3)));

			if(a != b && a != c && b!=c)
				return result1;

			if(a == b && a == c)
				return result3;
			else
				return result2;
		}

		/** 등차수열의 특정한 항만 더하기 Level_0 */
		public int solution(int a, int d, boolean[] included) {
			int answer = 0;

			int[] arr = new int[included.length];
			arr[0] = a;

			for (int i = 1; i <included.length ; i++) {
				arr[i] = arr[i-1] + d;
			}

			// boolean 배열이랑 위 배열이랑 비교해서 순번 맞추기
			for (int i = 0; i <included.length ; i++) {
				if(included[i]) {
					answer += arr[i];
				}
			}
			return answer;
		}

		/** 코드처리하기 Level_0 */
		public String solution(String code) {
			StringBuilder ret = new StringBuilder();

			int mode = 0;
			for (int i = 0; i < code.length(); i++) {
				char current = code.charAt(i);

				if(current == '1') {
					mode = 1-mode;
				} else {
					if(mode==0 && i%2==0) {
						ret.append(current);
					} else if(mode==1 && i%2==1) {
						ret.append(current);
					}
				}
			}
			if(ret.length()==0) {
				return "EMPTY";
			}
			return ret.toString();
		}

}
