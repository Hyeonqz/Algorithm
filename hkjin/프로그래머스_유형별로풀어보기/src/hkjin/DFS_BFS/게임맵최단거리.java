package hkjin.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        solution(new int[][]{{0,1,0,0},{0,0,0,0},{0,0,1,0}});
    }

    public static int solution(int[][] maps) {

        int n = maps.length; // 1차원 배열 (행)
        int m = maps[0].length; // 2차원 배열 (열)

        int[] dr = {-1, 1, 0, 0}; // 북, 남, 동, 서
        int[] dc = {0, 0, -1, 1}; // 북, 남, 동 ,서

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 (0,0) 출발점 자체도 1칸으로 카운트
        queue.add(new int[] {0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r= cur[0];
            int c= cur[1];
            int dist = cur[2];

            if (r == n-1 && c == m-1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 체크 + 벽 체크 + 방문 체크
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (maps[nr][nc] == 0)
                    continue;       // 힌트: 벽이면 스킵
                if (visited[nr][nc])
                    continue;      // 힌트: 이미 방문했으면 스킵

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, dist + 1});
            }
        }

        return -1;  // 목적지 도달 불가
    }

}
