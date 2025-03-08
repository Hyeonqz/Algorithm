import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static final String LEAVE = "leave";
	private static final String ENTER = "enter";

	public static void main (String[] args) throws IOException {
		Solution();
	}

	public static void Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String status = st.nextToken();

			// Enter 시 set 에 추가
			if(status.equals(ENTER)) {
				set.add(name);
			}
			// Enter 인 사람이 Leave 로 바뀔 경우가 있으므로 삭제
			if(status.equals(LEAVE)) {
				set.remove(name);
			}
		}

		List<String> list = new ArrayList<>(set);
		list.sort(Collections.reverseOrder());

		for (String name : list) {
			System.out.println(name);
		}

	}
}
