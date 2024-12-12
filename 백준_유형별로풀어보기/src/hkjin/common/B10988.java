package hkjin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String input = br.readLine();
		sb.append(input);
		sb.reverse();

		if(input.equalsIgnoreCase(sb.toString()))
			System.out.println("1");
		else {
			System.out.println("0");
		}
	}
}
