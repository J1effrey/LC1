package com.yyf.codesignal;

/**
 * cut all prefix palindrome substring
 * example: aaacodedoc => {aaa} {codedoc}
 */
public class CutPrefixesPalindrome {
    public static void main(String[] args) {
        System.out.println(solution("codesignal"));
        System.out.println(solution("aaacodedoc"));
    }

    public static String solution(String s) {
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (isPalidrome(s.substring(0, i)) && i > 1) {
                max = Math.max(max, i);
            }
        }
        if (max < 2) {
            return s;
        }
        return solution(s.substring(max));
    }

    public static boolean isPalidrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}

