package hkjin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1541 최솟값을 만드는 괄호 배치 찾기 (실버2)
 * 시간 제한 : 2초
 * 메모리 제한 : 128MB
 *
 * 문제 해석
 * - 수식의 값을 최소로 만들어야 한다.
 * - 최솟값을 만들기 위해서는 가장 큰 수를 빼면 된다.
 * - + 가 끝날 때 까지 괄호를 친다. 그리고 뺀다.
 */
public class B1541_최솟값을만드는괄호배치찾기 {
	static int answer = 0;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		String[] strArr = input.split("-");

		for (int i = 0; i <strArr.length; i++) {
			int tmp = mySum(strArr[i]);
			if(i==0)
				answer += tmp;
			else
				answer -= tmp;
		}
		System.out.println(answer);
	}

	private static int mySum (String arr) {
		int sum = 0;
		String[] str = arr.split("[+]");
		for (int i = 0; i <str.length ; i++) {
			sum += Integer.parseInt(str[i]);
		}

		return sum;
	}

}
