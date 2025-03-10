package hkjin.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 {
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		dfs(0);
		System.out.println(sb);
	}

	private static void dfs (int depth) {
		if (depth == M) {
			for(int value : arr) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N ; i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}

}

// 현재 문제는 중복되는 수열은 1번씩만 출력
// 1 1 1 2 1 3 1 4 2 1 2 2 2 3 2 4 ~ 4 3 4 4 이런식으로 출력