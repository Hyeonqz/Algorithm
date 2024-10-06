package hkjin.이진탐색;
/*
* 문제 : 원하는 정수 찾기 B1920 (실버4)
* 시간 제한: 2초
* 걸리 시간 : 40분
* 문제 부석
* N,M 의 크기 100,000 는 n^2 으로 풀수는 없다.
* 100,000 이므로 단순 반복문으로는 문제를 풀 수 없다, 그러므로 이진탐색 O(nlogn) 시간 복잡도로 해결할 수 있다.
* */

import java.util.Arrays;
import java.util.Scanner;

public class B1920_원하는정수찾기 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt();
		int[] A = new int[N];

		for (int i = 0; i <N ; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		int M = sc.nextInt();

		for (int i = 0; i <M ; i++) {
			boolean find = false;
			int target = sc.nextInt();
			int start = 0;
			int end = A.length - 1;

			while(start <= end) {
				int mid_index  = (start + end)/2;
				int mid_value = A[mid_index];
				if(mid_value > target) {
					end = mid_index - 1;
				} else if (mid_value < target) {
					start = mid_index + 1;
				} else {
					find = true;
					break;
				}
			}
			if(find)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
