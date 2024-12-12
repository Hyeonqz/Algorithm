package hkjin.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2587 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] list = new int[5];
		for (int i = 0; i <5 ; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int avg0 = 0;
		for (int i = 0; i < list.length; i++) {
			avg0 += list[i];
		}

		int result = avg0 / 5;

		Arrays.sort(list);

		System.out.println(result);
		System.out.println(list[2]);

	}

	public void bestPractice() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] list = new int[5];
		for (int i = 0; i <5 ; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int avg = Arrays.stream(list).sum() / list.length;
		Arrays.stream(list);
		int median = list[list.length/2];
	}
}
