import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int recursiveCount;
	private static int dpCount;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];

		fibRecursive(N);
		fibDP(N);

		System.out.println(recursiveCount + " " + dpCount);
	}

	private static int fibRecursive(int n) {
		if (n == 1 || n == 2) {
			recursiveCount++;
			return 1;
		} else {
			return fibRecursive(n - 1) + fibRecursive(n - 2);
		}
	}

	private static int fibDP(int n) {
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			dpCount++;
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}
}
