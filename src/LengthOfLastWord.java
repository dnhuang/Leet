package src;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--) { // loop backwards since we want length of last word
            // first condition is to check if the end has spaces, if has space, count should stay as 0
            // second condition checks for the first "break" of a space from the last word
            if (count != 0 && s.charAt(i) == ' ') {
                return count; // if counting already started and space is seen, we've traversed through the last word
            } else if (s.charAt(i) != ' ') { // this does the actual counting of the length of the last word
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord tester = new LengthOfLastWord();
        String input1 = "Hello World";
        String input2 = "    fly me   to   the moon   ";
        String input3 = "luffy is still joyboy";
        System.out.println(tester.lengthOfLastWord(input1));
        System.out.println(tester.lengthOfLastWord(input2));
        System.out.println(tester.lengthOfLastWord(input3));
    }
}
