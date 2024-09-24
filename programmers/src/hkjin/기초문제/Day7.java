package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {
	public static void main (String[] args) {

	}


	/** 배열 만들기4 */
	public int[] solution (int[] arr) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (list.isEmpty()) {
				list.add(arr[i]);
			} else if (list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
			} else {
				list.remove(list.size() - 1);
				i--;
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 콜라츠 수열 만들기 */
	public int[] solution (int n) {
		var list = new ArrayList<Integer>();

		list.add(n);

		while (n != 1) {
			n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
			list.add(n);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 수열과 구간 쿼리4 */
	public int[] solution (int[] arr, int[][] queries) {
		int[] answer = Arrays.copyOf(arr, arr.length);

		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];

			for (int j = s; j <= e; j++) {
				// 나머지가 0 이라는 것은 j가 k로 나누어 떨어진다는 것이므로, 배수라는 것을 의미한다.
				if (j % k == 0) {
					answer[j]++;
				}
			}
		}

		return answer;
	}

	/** 배열만들기2 */
	public int[] solution (int l, int r) {
		List<Integer> list = new ArrayList<>();

		for (int i = l; i <= r; i++) {
			boolean isValid = true;
			int num = i;

			while (num > 0) {
				int digit = num % 10;
				if (digit != 0 && digit != 5) {
					isValid = false;
					break;
				}
				num /= 10;
			}

			if (isValid) {
				list.add(i);
			}
		}

		if (list.isEmpty()) {
			return new int[] {-1};
		} else {
			return list.stream().mapToInt(Integer::intValue).toArray();
		}
	}

	/** 카운트 업*/
	public int[] solution1 (int start_num, int end_num) {
		List<Integer> list = new ArrayList<>();
		// start_num 부터 ~ end_num 까지 숫자를 차례로 담은 List 를 return

		for (int i = start_num; i <= end_num; i++) {
			list.add(i);
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
