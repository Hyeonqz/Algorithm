import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수
		K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수

		arr = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int currentSum = 0;
		// 처음 1 부터 k 까지의 누적합을 구한다 -> 출발점을 만든다.
		for (int i = 1; i <= K ; i++) {
			currentSum += arr[i];
		}

		int maxSum = currentSum;

		// 슬라이딩 윈도우 알고리즘 기법     
		for (int i = K+1; i <= N ; i++) {
			currentSum = currentSum - arr[i-K] + arr[i];
			if(currentSum > maxSum)
				maxSum = currentSum;
		}

		System.out.println(maxSum);
	}

}