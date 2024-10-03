package hkjin.기초문제;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day22 {
	public static void main (String[] args) {
		Day22 day22 = new Day22();
		System.out.println(
			Arrays.toString(day22.solution(new int[] {293, 1000, 395, 678, 94}, new int[] {94, 777, 104, 1000, 1, 12})));
	}

	// Day22 함수(메소드), 조건문 활용

	/** 0 떼기 */
	public String solution(String n_str) {
		int index = 0;
		if(n_str.charAt(0) == '0') {
			for (int i = 0; i <n_str.length() ; i++) {
				if(n_str.charAt(i) != '0') {
					index = i;
					break;
				}
			}
		} else {
			return n_str;
		}

		return n_str.substring(index, n_str.length()-1);
	}
	public String solution_best_practice1(String n_str) {
		return "" + Integer.parseInt(n_str);
	}

	/** 두 수의 합 */
	public String solution(String a, String b) {
		BigInteger c = new BigInteger(a);
		BigInteger d = new BigInteger(b);
		BigInteger add = c.add(d);
		return String.valueOf(add);
	}

	/** 문자열로 변환 */
	public String solution(int n) {
		return ""+n;
	}

	/** 배열의 원소 삭제하기 */
	public int[] solution(int[] arr, int[] delete_list) {
		List<Integer> answer = new ArrayList<>();
		for(int i = 0; i<arr.length;i++){
			answer.add(arr[i]);
			for(int j = 0; j<delete_list.length;j++){
				if(arr[i]==delete_list[j]){
					// 인덱스 삭제가 아닌, 값을 찾아서 삭제를 해준다.
					answer.remove(Integer.valueOf(arr[i]));
				}
			}
		}
		return answer.stream().mapToInt(Integer::valueOf).toArray();
	}

	/** 부분 문자열인지 확인하기 */
	public int solution1(String my_string, String target) {
		if(my_string.contains(target)) {
			return 1;
		} else {
			return 0;
		}
	}
}
