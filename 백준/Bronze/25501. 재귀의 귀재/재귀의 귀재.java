import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;
	public static void main (String[] args) throws IOException {
		Solution();
	}

	private static void Solution () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String input =  br.readLine();
			int palindrome = isPalindrome(input);
			System.out.println(palindrome + " " + count);
			count = 0;
		}
	}

	private static int isPalindrome(String s) {
		return recursions(s, 0, s.length()-1);
	}

	private static int recursions (String s, int i, int r) {
		count++;
		if(i >= r) {
			return 1;
		} else if(s.charAt(i) != s.charAt(r))
			return 0;
		else {
			return recursions(s, i+1, r-1);
		}
	}

}