/*Created by ${USER} on ${DATE}.
 *题意：给一个字符串 判断是否是一个有效的数字
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        if (s.matches("[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?"))
            return true;
        else
            return false;
    }
}

//第二次
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;

        s = s.trim();
        int n = s.length();

        if (n == 0) return false;

        // flags
        int signCount = 0;
        boolean hasE = false;
        boolean hasNum = false;
        boolean hasPoint = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // invalid character
            if (!isValid(c)) return false;

            // digit is always fine
            if (c >= '0' && c <= '9') hasNum = true;

            // e or E
            if (c == 'e' || c == 'E') {
                // e cannot appear twice and digits must be in front of it
                if (hasE || !hasNum) return false;
                // e cannot be the last one
                if (i == n - 1) return false;

                hasE = true;
            }

            // decimal place
            if (c == '.') {
                // . cannot appear twice and it cannot appear after e
                if (hasPoint || hasE) return false;
                // if . is the last one, digits must be in front of it, e.g. "7."
                if (i == n - 1 && !hasNum) return false;

                hasPoint = true;
            }

            // signs
            if (c == '+' || c == '-') {
                // no more than 2 signs
                if (signCount == 2) return false;
                // sign cannot be the last one
                if (i == n - 1) return false;
                // sign can appear in the middle only when e appears in front
                if (i > 0 && !hasE) return false;

                signCount++;
            }
        }

        return true;
    }

    boolean isValid(char c) {
        return c == '.' || c == '+' || c == '-' || c == 'e' || c == 'E' || c >= '0' && c <= '9';
    }
}