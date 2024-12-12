package hkjin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B25206 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String[]> list = new ArrayList<>();
		Map<String, Double> map = Map.of(
			"A+",4.5,
			"A0",4.0,
			"B+",3.5,
			"B0",3.0,
			"C+",2.5,
			"C0",2.0,
			"D+",1.5,
			"D0",1.0,
			"F",0.0
		);

		double totalScore = 0.0;
		double totalHakjum = 0.0;

		for (int i = 0; i < 20; i++) {
			String line = br.readLine();
			String[] parts = line.split(" ");
			String grade = parts[2];

			if(grade.equals("P"))
				continue;

			double credit = Double.parseDouble(parts[1]);
			double score = map.get(grade);

			totalScore += (credit * score);
			totalHakjum += credit;
		}

		if(totalHakjum > 0) {
			System.out.printf("%6f", totalScore/totalHakjum);
		} else {
			System.out.println("0.000000");
		}
	}
}
