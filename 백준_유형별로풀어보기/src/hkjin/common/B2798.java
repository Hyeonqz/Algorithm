package hkjin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int result = 0;

		// 5 21
		// 5 6 7 8 9
		// 0 1 2 3 4

		// 투포인터 알고리즘

		for (int i = 0; i < N - 2; i++) {
			int min = i + 1;
			int max = N - 1;

   			// 5 6 8
			while (min < max) {
				int sum = arr[i] + arr[min] + arr[max];

				if (sum <= M) {
					result = Math.max(result, sum);
					min++;
				} else {
					max--;
				}
			}
		}

		System.out.println(result);
	}
}
