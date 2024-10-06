package hkjin.greedy;
/*
 * 백준 11047 동전개수의 최솟값 구하기 (실버4)
 * 시간 제한 :  1초
 * 걸린 시간 : 40분

 * 문제 해석
 * 동전은 N 종류이고, 동전의 개수가 많다
 * 동전을 적절히 사용해 가격의 합 K 를 만들꺼다
 * 이때 필요한 동전의 개수의 최솟값을 찾자.
 * N개의 동전 갯수로, M 목표 금액의 최소 몇개로 만들수 있는지
 * - 최대한 금액이 큰 동전부터 구성을 한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047_동전개수의최솟값구하기 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i] <= K) {
				answer += K / arr[i];
				K %= arr[i];
			}
		}
	}
}

