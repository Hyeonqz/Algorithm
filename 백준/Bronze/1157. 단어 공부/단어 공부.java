import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int count = 0;
	static Map<Character, Integer> map = new HashMap<>();

	public static void main (String[] args) throws IOException {
		String input = getInput();

		FindMethod(input);

		char result = getResult();
		outPutMethod(result);

	}

	private static void outPutMethod (char result) {
		System.out.println(Character.toUpperCase(result));
	}

	private static char getResult () {
		int maxCount = 0;
		char result = '?';
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				result = entry.getKey();
			} else if (entry.getValue() == maxCount) {
				result = '?';
			}
		}
		return result;
	}

	private static void FindMethod (String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
	}

	private static String getInput () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine().toLowerCase();
		return input;
	}

}
