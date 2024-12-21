import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();

		StringBuilder sb = new StringBuilder();
		sb.append(a);

		StringBuilder sb2 = new StringBuilder();
		sb2.append(b);

		int n = Integer.parseInt(sb.reverse().toString()); 
		int m = Integer.parseInt(sb2.reverse().toString()); 

		if(n>m) {
			System.out.println(n);
		} else {
			System.out.println(m);
		}
	}
}
