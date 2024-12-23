import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			String[] arr = br.readLine().split(" ");
			int repeat = Integer.parseInt(arr[0]);
			String repeatStr = arr[1];

			for (char c : repeatStr.toCharArray()) {
				sb.append(String.valueOf(c).repeat(repeat));
			}
			System.out.println(sb.toString());
		}

	}

}
