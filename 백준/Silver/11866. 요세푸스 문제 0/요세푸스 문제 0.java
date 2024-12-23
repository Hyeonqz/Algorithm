import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N ; i++) {
			queue.add(i);
		}

		List<Integer> result= new LinkedList<>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			idx = (idx + K -1) % queue.size();
			result.add(queue.remove(idx) +1);
		}


		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i < result.size() - 1) System.out.print(", ");
		}
		System.out.print(">");

	}
}
