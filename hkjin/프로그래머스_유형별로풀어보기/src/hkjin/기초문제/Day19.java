package hkjin.기초문제;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

public class Day19 {
	public static void main (String[] args) {
		Day19 day19 = new Day19();
		System.out.println(day19.solution("baconlettucetomato"));
	}

	// Day19 - 문자열, 리스트(배열)

	/** 세 개의 구분자 */
	public String[] solution(String myStr) {
		var list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <myStr.length() ; i++) {
			char c = myStr.charAt(i);

			if(c != 'a' && c != 'b' && c != 'c')
				sb.append(c);
			else
				if(sb.length() > 0) {
					list.add(sb.toString());
					sb.setLength(0);
				}
		}

		if(sb.length() > 0 )
			list.add(sb.toString());

		if(list.isEmpty())
			return new String[] {"EMPTY"};

		return list.toArray(new String[list.size()]);
	}

	/** 배열의 원소만큼 추가하기 */
	public int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <arr[i] ; j++) {
				list.add(arr[i]);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 빈 배열에 추가,삭제하기 */
	public int[] solution(int[] arr, boolean[] flag) {
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<flag.length; i++) {
			if(flag[i]) {
				for (int j = 0; j < arr[i]*2; j++) {
					list.add(arr[i]);
				}
			} else {
				for (int j = 0; j < arr[i]; j++) {
					list.remove(list.size()-1);
				}
			}
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 배열 만들기6 */
	public int[] solution1(int[] arr) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (list.isEmpty()) {
				list.add(arr[i]);
			} else if (list.get(list.size() - 1) == arr[i]) {
				list.remove(list.size() - 1);
			} else {
				list.add(arr[i]);
			}
		}

		if (list.isEmpty()) {
			return new int[]{-1};
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	/** 무작위로 K개의 수 뽑기 */
	public int[] solution(int[] arr, int k) {
		Set<Integer> set = new HashSet<>();
		int[] answer = new int[k];

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(!set.contains(arr[i])) {
				set.add(arr[i]);
				answer[count++] = arr[i];
			}

			if(count == k)
				break;
		}

		for (int i = count; i < k ; i++) {
			answer[i] = -1;
		}

		return answer;
	}

}
