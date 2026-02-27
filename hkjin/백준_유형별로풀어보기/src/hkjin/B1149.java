package hkjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주제: RGB 거리 <br>
 * <p><a href="https://www.acmicpc.net/problem/1149">링크</a></p>
 * */
public class B1149 {
    public static void main(String[] args) throws IOException{
        int[][] arr2 = new int[1000][1000];
        inputData(arr2);

    }

    /**
     * 입력 기본
     * */
    private static void inputData(int[][] arr2) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
