package hkjin.스택_큐;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {

    }

    public boolean solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
