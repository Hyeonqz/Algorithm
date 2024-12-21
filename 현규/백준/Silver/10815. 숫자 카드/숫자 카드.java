import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Set<Integer> hasCardSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			hasCardSet.add(number); 
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (hasCardSet.contains(number))
				result.add(1);
			else
				result.add(0);
		}

		for (int res : result) {
			System.out.print(res + " ");
		}
	}
}
