package src;

public class LongestCommonPrefix {
    /** Write a function to find the longest common prefix string amonst
     * an array of strings.
     * @param strs
     * @return String of the longest common prefix, otherwise empty STring
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            String currChar = strs[0].substring(i, i+1);
            for (int j = 1; j < strs.length; j++) {

                // First condition to check consecutive words, return if reach the end
                // Second condition is to check equality
                if ((i >= strs[j].length()) || (!strs[j].substring(i, i+1).equals(currChar))) {
                    return prefix;
                }
            }
            prefix += currChar;
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix tester = new LongestCommonPrefix();
        String[] input1 = new String[]{"flower", "flow", "flight"};
        System.out.println(tester.longestCommonPrefix(input1));
        String[] input2 = new String[]{"dog", "racecar", "car"};
        System.out.println(tester.longestCommonPrefix(input2));
        String[] input3 = new String[]{"ab", "a"};
        System.out.println(tester.longestCommonPrefix(input3));
    }
}
