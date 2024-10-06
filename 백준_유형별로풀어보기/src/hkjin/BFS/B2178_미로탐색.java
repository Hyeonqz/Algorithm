package hkjin.BFS;

/*
* 백준 2178 미로 탐색하기 (실버1)
* 시간 제한 :  1초
* 걸린 시간 : 1시간
* 문제 해석
* 1) 4*6 크기으 배열로 표현되는 미로가 있다.
* 2) (n,m) 의 위치로 이동하기 위해 가야하는 최단 거리를 구해야 한다.
* 3) n,m 은 100 이므로 크게 시간복잡도를 고려하지 않아도 된다.
* 4) 너비 기반 탐색이므로 depth 대로 쭉 내려오고, 맨 마지막에 도착한 순간 그게 최솟값이다.
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] A;
	static int N;
	static int M;

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken(); // 1011010101
			for (int j = 0; j < M ; j++) {
				A[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}

		// BFS 돌리기
		BFS(N,M);

	}

	private static void BFS (int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer( new int[] {i,j} );

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[i][j] = true;

			for (int k=0; k<4; k++) { // 상하좌우로 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dx[k];

				if(x >=0 && y>=0 && x < N && y < M) { // 배열을 넘어가면 안됌
					if(A[x][y] == 0 && !visited[x][y]) { // 0이여서 갈 수없거나, 이미 방문한 곳은 방문 불가함.
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]] + 1;
						queue.add(new int[] {x,y});
					}
				}
			}
		}

	}

}
