import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr = new boolean[101][101];
	public static void main (String[] args) throws IOException {
		Solution();
	}

	private static void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int total = 0;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if (!arr[j][k]) {
						arr[j][k] = true;
						total++;
					}
				}
			}

		}
		System.out.println(total);

	}
}
