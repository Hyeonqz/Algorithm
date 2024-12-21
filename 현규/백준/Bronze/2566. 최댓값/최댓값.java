import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] twoArr = new int[9][9];

		for (int i = 0; i < twoArr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < twoArr.length ; j++) {
				twoArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		int[] arr = new int[2];

		for (int i = 0; i < twoArr.length; i++) {
			for (int j = 0; j < twoArr.length; j++) {

				if(twoArr[i][j] >= result) {
					result = twoArr[i][j];
					arr[0] = i+1;
					arr[1] = j+1;
				}
			}
		}

		System.out.println(result);
		System.out.println(arr[0] + " " + arr[1]);

	}
}
