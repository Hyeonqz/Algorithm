import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		if(n>m) {
			System.out.println(n*m/findGCD(n,m));
		} else if(n<m) {
			System.out.println(n*m/findGCD(m,n));
		} else {
			System.out.println(n);
		}
	}
	
	static long findGCD(long a, long b) {
		while (b != 0) {
			long gcd = a%b;
			a = b;
			b = gcd;
		}
		return a;
	}

}