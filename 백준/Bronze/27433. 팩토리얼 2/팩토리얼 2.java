import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		System.out.println(factorial(N));
	}

	private static long factorial (long n) {
		if(n <= 1)
			return 1L;
		return n * factorial(n-1);
	}

}

/* N! 10! -> 10*9*8 ~ */
// 자료구조 int -> long