package hkjin.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1929 소수구하기(실버3)
 * 시간 제한 : 2초
 * 메모리 제한 : 256MB

 * 문제 해석
 * N ~ M 사이의 소수를 찾기만 하면 된다.
 * 에라토스테네스의 체를 사용하면 금방 풀 수 있다.
 *
 * 결과	시간초
 * 성공	192ms
 */
public class B1929_소수구하기 {
	private static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		check = new boolean[end+1];
		isPrime();

		for (int i = start; i <= end; i++) {
			if (!check[i]) sb.append(i).append("\n");
		}
		System.out.println(sb);

	}
	public static void isPrime() {
		int limit = (int)Math.sqrt(check.length-1);
		check[1] = true;

		for (int i = 2; i <= limit; i++) {
			if (check[i] == true) continue;

			for (int j = i*i; j < check.length; j+=i) {
				check[j] = true;
			}
		}

	}

}
