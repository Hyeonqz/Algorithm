import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		solution();
	}

	private static void solution () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		var map1 = new HashMap<String, Integer>();
		var map2 = new HashMap<Integer, String>();

		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			map1.put(input, i);
			map2.put(i, input);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();

			if (Character.isDigit(s.charAt(0))) sb.append(map2.get(Integer.parseInt(s))).append("\n");
			else sb.append(map1.get(s)).append("\n");
		}

		System.out.println(sb);
	}

}