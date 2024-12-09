import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;

		while (N >= 0) {
			if (N % 5 == 0) {
				count += N / 5;
				System.out.println(count);
				return;
			}
			N -= 3;
			count++;
		}

		System.out.println("-1");
	}
}

/* 경우의 수
 *  N 이 5의 배수 일 떄
 *  N 이 5의 배수가 아닐 때
 *  N 이 3의 배수 일 때
 *  N 이 3과5 의 조합으로 만들 수 있을 떄
 *  N 이 3과5 조합으로 만들 수 없을 때
 * */