import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int count = 0;

		List<String> croatiaAlphabets = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

		for (int i = 0; i < input.length(); ) {
			boolean found = false;

			for (String str : croatiaAlphabets) {
				if (i + str.length() <= input.length() && input.substring(i, i + str.length()).equals(str)) {
					count++;        
					i += str.length(); 
					found = true;
					break;
				}
			}

			if (!found) {
				count++;
				i++;
			}
		}

		System.out.println(count);
	}
}
