package hkjin.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2903 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());

		int d = 2;
		for (int i = 1; i <= input; i++) {
			d = d+(d-1);
		}

		// 총 변의 개수는 점의 수의 제곱하면 나온다.
		int result = (int)Math.pow(d,2);
		System.out.println(result);
	}
}

/*
* 점이
* d = 2 -> 처음 주어진 점의 개수는 4개지만, 첫번째 변에 있는 점으 개수는 2개
* 1 2 4 8 16
* 이런식으로 2^0 제곱부터 d+2^n 제곱순으로 점이 증가하고 있다.
* 한 변의 총 점의 개수를 구한다음, 그 점의 개수를 제곱하면 총 점의 개수가 나온다.
* */
