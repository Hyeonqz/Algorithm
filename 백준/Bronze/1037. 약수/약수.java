import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		while(T-- > 0) {
			int N = Integer.parseInt(st.nextToken());
			max = Math.max(N, max);
			min = Math.min(N, min);
		}
		System.out.println(max * min);

	}
}

/*
*  약수 result 는 A 의 배수여야하고, A 는 1과 N 이 아니어야 함
* */

/*
* 24 약수 개수
* 2 3 4 6 8 12
* 최소공배수 공식처럼? 흠 고민좀 해봐야 할듯?
* */