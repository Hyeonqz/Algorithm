package hkjin.정수론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13241 {
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

/* 최대 공약수를 구한다 -> 유클리드 호제법(GCD) */
/* 최소공배수 -> n*m/최대공약수 공식을 알아야 함 */
/* n이 클수도 있고 m이 클수도 있기 때문에 반대조건도 필수 */