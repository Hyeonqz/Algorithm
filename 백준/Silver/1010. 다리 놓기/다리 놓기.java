import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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