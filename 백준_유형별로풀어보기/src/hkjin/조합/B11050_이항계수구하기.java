package hkjin.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 11050 이항계수 구하기(브론즈1)
 * 시간 제한 : 1초
 * 메모리 제한 : 256MB

 * 문제 해석
 * 자연수 N, 정수 K 가 주어졌을 때 이항 계수(N/K) 를 구해라
 *
 * 결과	시간초
 * 성공	192ms
 */
public class B11050_이항계수구하기 {
	public static void main (String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		String[] inputs = br.readLine().split(" ");

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];

		// 초기화
		for (int i = 0; i <= N; i++) {
			arr[i][i] = 1;
			arr[i][0] = 1;
			arr[i][1] = 1;
		}

		// 점화식으로 배열 완성하기
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		System.out.println(arr[N][K]);
	}

}
