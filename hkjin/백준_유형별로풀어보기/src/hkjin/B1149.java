package hkjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주제: RGB 거리 <br>
 * <p><a href="https://www.acmicpc.net/problem/1149">링크</a></p>
 * <p>알고리즘: DP </p>
 * <p>시간복잡도: 0(N)</p>
 * <p>공간복잡도: 0(N * 3)</p>
 * */
public class B1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // [j] 는 R,G,B 3개 고정
        int[][] cost = new int[N][3];

        // dp[i][j] = i번째 집을 j색으로 칠할 때 최소 비용
        int[][] dp = new int[N][3];

        // [1] 데이터 입력
        inputData(N, br, cost);

        // [2] DP 초기값 세팅 (첫 번째 집은 그냥 비용 그대로)
        dp[0][0] = cost[0][0]; // R
        dp[0][1] = cost[0][1]; // G
        dp[0][2] = cost[0][2]; // B

        // [3] DP 점화식 적용
        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 빨강
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 초록
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 파랑
        }

        // [4] 마지막 집의 3가지 색 중 최솟값 출력
        int answer = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(answer);
    }

    private static void inputData(int N, BufferedReader br, int[][] cost) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
