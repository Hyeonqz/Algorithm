import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int white = 0;
	static int blue = 0;

	public static void main (String[] args) throws IOException {
		Solution_B2630();
	}

	private static void Solution_B2630 () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];

		inputHandler(n, br, paper);

		// 분할 정복을 해야한다.
		divide(paper,0,0,n);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void divide (int[][] paper, int x, int y, int n) {
		// 현재가 같은 컬러가 4개 인지 체크하기
		if (isSameColor(paper, x, y, n)) {
			if (paper[x][y] == 0) {
				white++; // 하얀색 종이 추가
			} else {
				blue++; // 파란색 종이 추가
			}
			return; // 더 이상 나눌 필요 없음
		}

		// 현재 영역을 4등분하여 다시 확인
		int newSize = n / 2; // 나눌 영역의 크기
		divide(paper, x, y, newSize); // 1번 영역
		divide(paper, x, y + newSize, newSize); // 2번 영역
		divide(paper, x + newSize, y, newSize); // 3번 영역
		divide(paper, x + newSize, y + newSize, newSize); // 4번 영역
	}

	// 현재 영역이 모두 같은 색인지 확인하는 함수
	private static boolean isSameColor(int[][] paper, int x, int y, int n) {
		int color = paper[x][y]; // 첫 번째 칸의 색
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (paper[i][j] != color) {
					return false; // 다른 색이 섞여 있음
				}
			}
		}
		return true; // 모두 같은 색
	}

	private static void inputHandler (int s, BufferedReader br, int[][] bool) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < s; j++) {
				bool[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
