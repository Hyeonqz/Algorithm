import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		String end = "666";

		int result = 666;
		int count = 0;

		while (true) {
			if(String.valueOf(result).contains(end)) {
				count++;
				if(count == input) {
					System.out.println(result);
					break;
				}
			}
			result++;
		}
	}
}