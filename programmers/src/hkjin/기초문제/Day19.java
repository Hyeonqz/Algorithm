package hkjin.기초문제;

import java.util.ArrayList;

public class Day19 {
	public static void main (String[] args) {
		Day19 day19 = new Day19();
		System.out.println(day19.solution("baconlettucetomato"));
	}

	/** 세 개의 구분자 */
	public String[] solution(String myStr) {
		var list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <myStr.length() ; i++) {
			char c = myStr.charAt(i);

			if(c != 'a' && c != 'b' && c != 'c')
				sb.append(c);
			else
				if(sb.length() > 0) {
					list.add(sb.toString());
					sb.setLength(0);
				}
		}

		if(sb.length() > 0 )
			list.add(sb.toString());

		if(list.isEmpty())
			return new String[] {"EMPTY"};

		return list.toArray(new String[list.size()]);
	}
}
