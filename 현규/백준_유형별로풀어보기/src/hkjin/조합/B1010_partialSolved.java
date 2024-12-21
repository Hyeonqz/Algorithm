package hkjin.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010_partialSolved {
	static int N,M;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수

		for (int i = 0; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int combination = Combination(M, N);
			System.out.println(combination);
		}
	}

	private static int Combination (int m, int n) {
		int result = 1;

		for (int i = 0; i < n; i++) {
			result *= (m-i);
			result /= (i+1);
		}
		return result;
	}

}

/* 문제 분석
* 서쪽 N 개의 사이트가 있고 동쪽에는 M 개의 사이트가 있다.
* 서쪽과 동쪽을 다리로 연결하려고 한다. (한 사이트는 최대 1개의 다리만 연결 가능)
* -> 서쪽(N) <= 동쪽(M)
* 다리를 최대한 많이 지어야해서 서쪽의 N 개 만큼 다리를 지으려고 한다.
* 다리 끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수 작성
* 모든 경우의 수를 리턴해야 한다.
*
* -> 순서에 상관없이 선택하는 경우의 수를 구한다 -> '조합'
*/
