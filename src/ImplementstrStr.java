package src;

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {

        // Empty string, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // only need to loop up to haystack length - needle length
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) { // first character match
                for (int j = 0; j < needle.length(); j++) { // check if string matches
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break; // doesn't match, break from loop
                    }
                    if (j == needle.length() - 1) {
                        return i; // entire string matched, return the starting matching index
                    }
                }
            }
        }
        return -1; // no matches
    }

    public static void main(String[] args) {
        ImplementstrStr tester = new ImplementstrStr();
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println(tester.strStr(haystack1,needle1));
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println(tester.strStr(haystack2, needle2));
        System.out.println(tester.strStr("hello", ""));
        System.out.println(tester.strStr("a", "a"));
    }
}
