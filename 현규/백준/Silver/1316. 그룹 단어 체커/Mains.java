import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mains {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < N ; i++) {
			String str = br.readLine();
			if(check(str) == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean check(String str) throws IOException {
		boolean[] check = new boolean[26];
		int prev = 0;

        // char 에 배열 자리에 한번 나왔으면 true 로 바꾼다.
		for (int i = 0; i <str.length() ; i++) {
			int now = str.charAt(i);

			if(prev != now) {
				if(check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				}
				else {
					return false;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}

}