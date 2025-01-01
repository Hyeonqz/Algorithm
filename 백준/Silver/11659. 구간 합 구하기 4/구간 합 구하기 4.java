import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int i,j;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 첫째 줄 입력
		N = Integer.parseInt(st.nextToken()); // 수의 개수 N
		M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수 M

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		// 둘째 줄 입력
		for (int i = 1; i <= N ; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}

		// 실제 구간합 로직
		StringBuilder sb = new StringBuilder();
		for (int s = 0; s < M; s++) {
			st = new StringTokenizer(br.readLine()," ");
			i = Integer.parseInt(st.nextToken()); // 구간합 첫 구간
			j = Integer.parseInt(st.nextToken()); // 구간합 마지막 구간

			// arr[j] 는 처음부터 끝까지 구간합이므로 i-1 만큼의 합을 빼줘야 한다.
			sb.append(arr[j] - arr[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}