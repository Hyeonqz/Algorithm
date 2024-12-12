package hkjin.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 브루트포스 나중에 다시 풀어보기 0부터 모든 경우의 수 계산 */
public class B2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 1; i < N; i++) {
			int sum = i + total(i);

			if (sum == N) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

	private static int total(int num) {
		int sum = 0;

		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}

		return sum;
	}
}