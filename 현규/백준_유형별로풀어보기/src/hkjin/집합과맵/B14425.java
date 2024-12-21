package hkjin.집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B14425 {
	static int count = 0;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String,String> map = new HashMap<>();

		int n = Integer.parseInt(st.nextToken()); // n개의 문자열
		int m = Integer.parseInt(st.nextToken()); // 집합 S

		// 집합이 있는 map
		for (int i = 0; i <n ; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			map.put(s,s);
		}

		for (int i = 0; i < m ; i++) {
			if(map.containsKey(br.readLine()))
				count++;
		}

		System.out.println(count);
	}
}
