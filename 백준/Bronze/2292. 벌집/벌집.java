import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		int count = 1;
		int range = 1;

		if(input == 1) {
			System.out.println("1");
			return;
		}

		while(range < input) {
			range += 6 * count; 
            count++;
		}

		System.out.println(count);
	}
}
