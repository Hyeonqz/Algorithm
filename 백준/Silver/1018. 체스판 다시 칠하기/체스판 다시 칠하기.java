import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] arr;
	public static int min = 64; // 8*8 체스판 전체를 칠해야 하는 최악의 경우의 수
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < m; j++) {
				if(str.charAt(j) == 'W') {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
			}
		}

		int row = n-7;
		int col = m-7;

		for (int i = 0; i < row ; i++) {
			for (int j = 0; j < col; j++) {
				find(i,j);// i,j 를 시작점으로 8*8 체크판 검사
			}
		}
		System.out.println(min);
	}

	private static void find (int x, int y) {
		int end_x = x+8;
		int end_y = y+8;
		int count = 0;

		boolean TF = arr[x][y]; // 시작점의 색 true -> 'W', false -> 'B'

		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
				if(arr[i][j] != TF) {
					count++; // 색이 다르면 다시 칠하기
				}
				TF = (!TF); // 다음 칸 예상 색상 변경
			}
			TF = !TF; // 다음 행의 예상 시작 색상 변경
		}
		count = Math.min(count, 64-count);

		min = Math.min(min, count);
	}

}
