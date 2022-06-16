package src;

public class AddBinary {
    public String addBinary(String a, String b) {
        // Check for 0 itself
        if (a.equals("0")) {
            return b;
        }

        String binaryReversed = "";
        boolean carryOver = false;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while (aIndex >= 0 && bIndex >= 0) {
            boolean[] addInfo = addHelper(a.charAt(aIndex), b.charAt(bIndex), carryOver);
            carryOver = addInfo[1];
            if (addInfo[0]) {
                binaryReversed = binaryReversed + "1";
            } else {
                binaryReversed = binaryReversed + "0";
            }
            aIndex--;
            bIndex--;
        }

        // check what string is longer
        if (aIndex < 0 && bIndex < 0 && carryOver) { // no operations left on a or b, just do carry over
            binaryReversed = binaryReversed + "1";
        } else if (aIndex < 0 && carryOver) { // do rest operations on b
            while (bIndex >= 0) {
                boolean[] addInfo = addHelper(' ', b.charAt(bIndex), carryOver);
                carryOver = addInfo[1];
                if (addInfo[0]) {
                    binaryReversed = binaryReversed + "1";
                } else {
                    binaryReversed = binaryReversed + "0";
                }
                bIndex--;
            }
        } else if (bIndex < 0 && carryOver) { // do rest operations on a
            while (aIndex >= 0) {
                boolean[] addInfo = addHelper(a.charAt(aIndex),' ', carryOver);
                carryOver = addInfo[1];
                if (addInfo[0]) {
                    binaryReversed = binaryReversed + "1";
                } else {
                    binaryReversed = binaryReversed + "0";
                }
                aIndex--;
            }
        } else if (aIndex < 0) { // no carry overs, copy rest of string b over
            for (int j = bIndex; j >= 0; j--) {
                binaryReversed = binaryReversed + b.substring(bIndex, bIndex + 1);
                bIndex--;
            }
        } else {
            for (int j = aIndex; j >= 0; j--) {
                binaryReversed = binaryReversed + a.substring(aIndex, aIndex + 1);
                aIndex--;
            }
        }

        // one last carry over check
        if (carryOver && binaryReversed.charAt(binaryReversed.length() - 1) == '0') {
            binaryReversed = binaryReversed + "1";
        }

        return stringReverseHelper(binaryReversed);
    }

    /**
     *
     * @param a single bit character to be added
     * @param b single bit character to be added
     * @return boolean array of size 2, 0th element is true if 1, false if 0, and 1st element true if carry over
     */
    public boolean[] addHelper(char a, char b, boolean carry) {
        if (a == ' ') {
            if (b == '1' && carry) {
                return new boolean[]{false, true};
            } else if (b == '0' && carry) {
                return new boolean[]{true, false};
            } else if (b == '1') {
                return new boolean[]{true, false};
            }
            return new boolean[]{false, false};
        }

        if (b == ' ') {
            if (a == '1' && carry) {
                return new boolean[]{false, true};
            } else if (a == '0' && carry) {
                return new boolean[]{true, false};
            } else if (a == '1') {
                return new boolean[]{true, false};
            }
            return new boolean[]{false, false};
        }

        if (a == '1' && b == '1') {
            if (carry) {
                return new boolean[]{true, true};
            }
            return new boolean[]{false, true};
        } else if (a == '1' && b == '0' || a == '0' && b == '1') {
            if (carry) {
                return new boolean[]{false, true};
            }
            return new boolean[]{true, false};
        }
        if (carry) {
            return new boolean[]{true, false};
        }
        return new boolean[]{false, false};
    }

    public String stringReverseHelper(String s) {
        String reversedString = "";
        for (int i = s.length()-1; i >= 0; i--) {
            reversedString = reversedString + s.substring(i, i + 1);
        }
        return reversedString;
    }

    public static void main(String[] args) {
        AddBinary tester = new AddBinary();
        String input1a = "11";
        String input1b = "1";
        String input2a = "1010";
        String input2b = "1011";
        System.out.println(tester.addBinary(input1a, input1b));
        System.out.println(tester.addBinary(input2a, input2b));
        String input3a = "100";
        String input3b = "110010";
        System.out.println(tester.addBinary(input3a, input3b));
        String input4a = "1101";
        String input4b = "10";
        System.out.println(tester.addBinary(input4a, input4b));
    }
}
