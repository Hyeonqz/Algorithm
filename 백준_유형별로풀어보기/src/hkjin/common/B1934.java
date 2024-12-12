package hkjin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int S = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int d = gcd(N, M);

			sb.append(N * M / d).append("\n");
		}
		System.out.println(sb);
	}

	private static int gcd (int n, int m) {
		while (m != 0) {
			int r = n % m;

			n = m;
			m = r;
		}
		return n;
	}

}
