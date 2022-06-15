package src;

import java.util.Stack;
public class ValidParentheses {
    /**
     * Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     * @param s
     * @return true if valid input string and false otherwise.
     */
    public boolean isValid(String s) {
        if (!isValidStart(s, 0)) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            // If stack is empty, check valid start
            if (stack.isEmpty()) {
                if (!isValidStart(s, i)) {
                    return false;
                }
                stack.push(s.charAt(i));
                continue;
            }

            // Not empty, proceed
            char currChar = s.charAt(i); // Get the current parenthesis we are on
            char prevChar = stack.peek(); // Check the most recent parenthesis in the stack

            // FOUR possibilities:
            // 1. If prev char == '('
            if (prevChar == '(') {
                if (currChar == '}' || currChar == ']') {
                    return false;
                } else if (currChar == ')') { // is a match, pop from stack
                    stack.pop();
                } else {
                    stack.push(currChar);
                }
            } else if (prevChar == '{') { // 2. If prev char == '{'
                if (currChar == ')' || currChar == ']') {
                    return false;
                } else if (currChar == '}') {
                    stack.pop();
                } else {
                    stack.push(currChar);
                }
            } else if (prevChar == '[') { // 3. If prev char == '['
                if (currChar == '}' || currChar == ')') {
                    return false;
                } else if (currChar == ']') {
                    stack.pop();
                } else {
                    stack.push(currChar);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidStart(String s, int i) {
        if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
            // System.out.println("Terminating Early");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses tester = new ValidParentheses();
        String input1 = "()";
        String input2 = "()[]{}";
        System.out.println(tester.isValid(input1));
        System.out.println(tester.isValid(input2));
        String input3 = "(]";
        System.out.println(tester.isValid(input3));
        String input4 = "{[]}";
        System.out.println(tester.isValid(input4));
    }
}
