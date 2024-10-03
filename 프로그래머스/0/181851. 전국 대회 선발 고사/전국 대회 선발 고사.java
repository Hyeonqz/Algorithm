import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
		var list =  new ArrayList<Integer>();

		for (int i = 0; i < rank.length ; i++) {
			if(attendance[i]) {
				list.add(i);
			}
		}

		list.sort(Comparator.comparingInt(a -> rank[a]));

		return 10000*list.get(0) + 100*list.get(1) + list.get(2);
    }
}