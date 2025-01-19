package hkjin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10798_solved {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] twoChar = new char[5][15];
		int max = 0;

		for (int i = 0; i < 5; i++) {
			String s = br.readLine();

			if(max < s.length()) max = s.length();

			for (int j = 0; j < s.length(); j++) {
				twoChar[i][j] = s.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if(twoChar[j][i] == '\0') continue;

				sb.append(twoChar[j][i]);
			}
		}

		System.out.println(sb);
	}
}