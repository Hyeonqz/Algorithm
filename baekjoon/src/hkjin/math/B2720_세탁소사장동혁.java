package hkjin.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
세탁소 사장 동혁 (브론즈3)

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	43204	29818	26668	69.753%
*
* */
public class B2720_세탁소사장동혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int C = Integer.parseInt(br.readLine());

			int quarter = C / 25;
			C %= 25;

			int dime = C / 10;
			C %= 10;

			int nickel = C / 5;
			C %= 5;

			int penny = C;

			System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
		}
	}
}
