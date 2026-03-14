package hkjin.해시;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {

    }

    /*
    * 목적: 비교 규칙
    * 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬.
    *
    * */
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {

            char ca = a.charAt(n);
            char cb = b.charAt(n);

            if (ca != cb) {
                return ca - cb;
            }

            return a.compareTo(b);
        });

        return strings;
    }

}
