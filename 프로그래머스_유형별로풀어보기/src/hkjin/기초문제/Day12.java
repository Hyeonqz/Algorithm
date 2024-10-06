package hkjin.기초문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12 {
	public static void main (String[] args) {
	}

	/** 리스트 자르기 (살짝 어려웠음) */
	public int[] solution(int n, int[] slicer, int[] num_list) {
		int a = slicer[0];
		int b = slicer[1];
		int c = slicer[2];

		switch (n) {
			case 1:
				return Arrays.copyOfRange(num_list, 0, b + 1); // 0부터, b+1 까지
			case 2:
				return Arrays.copyOfRange(num_list, a, num_list.length);
			case 3:
				return Arrays.copyOfRange(num_list, a, b + 1);
			case 4:
				int[] result = new int[(b - a) / c + 1];
				for (int i = a, j = 0; i <= b; i += c, j++) {
					result[j] = num_list[i];
				}
				return result;
			default:
				return new int[]{};
		}
	}

	/** 첫 번째로 나오는 음수 */
	public int solution(int[] num_list) {
		for (int i = 0; i < num_list.length; i++) {
			if(num_list[i] < 0)
				return i;
		}
		return -1;
	}

	/** 배열 만들기 3 */
	public int[] solution(int[] arr, int[][] intervals) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i <intervals.length ; i++) {
			int s = intervals[i][0];
			int e = intervals[i][1];

			int[] intArr = Arrays.copyOfRange(arr, s, e+1);

			for (int j =0; j <intArr.length ; j++) {
				list.add(intArr[j]);
			}

		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 2의 영역 */
	public int[] solution1(int[] arr) {
		int[] answer = {};

		int start = -1;
		int end = -1;

		for (int i = 0; i <arr.length ; i++) {
			if(arr[i] == 2) {
				start = i;
				break;
			}
		}

		for (int i = arr.length-1; i > 0; i--) {
			if(arr[i] == 2) {
				end = i;
				break;
			}
		}

		if(start==-1 && end == -1)
			return new int[]{-1};

		return Arrays.copyOfRange(arr,start,end+1);
	}

	/** 배열 조각하기 */
	public int[] solution(int[] arr, int[] query) {
		// 짝수 인덱스에서는 arr 에서 query[i] 번 인덱스를 제외하고 배열의 query[i] 번 인덱스 뒷부분을 잘라서 버린다.
		// 홀수 인덱스에서는 arr 에서 query[i] 번 인덱스는 제외하고 배열의 query[i] 번 인덱스 앞 부분을 잘라서 버린다.
		// 위 작업 마치고 arr 부분 배열
		var list = new ArrayList<Integer>();

		for(int num : arr) {
			list.add(num);
		}


		for (int i = 0; i < query.length; i++) {
			int cutIndex = query[i];
			if (i % 2 == 0) {
				while (list.size() > cutIndex + 1) {
					list.remove(list.size() - 1);
				}

			} else {
				for (int j = 0; j < cutIndex; j++) {
					list.remove(0);
				}
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}


}
