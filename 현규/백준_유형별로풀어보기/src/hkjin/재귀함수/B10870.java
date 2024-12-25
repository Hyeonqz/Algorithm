package hkjin.재귀함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870 {
	static long result = 0;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		System.out.println(makeFibonacci(N));

	}

	private static long makeFibonacci (long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return makeFibonacci(n-1) + makeFibonacci(n-2);
	}
}

/* 피보나치 수열
* f10 = f9+f8
*
* */