package src;

public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        int prevInt = 0; // used to determine exceptions

        for(int i = 0; i < s.length(); i++) {
            String currRoman = s.substring(i , i+1);
            int currInt = helper(currRoman);


            if (checkException(prevInt, currInt)) {
                sum += currInt - 2 * prevInt;
            } else {
                sum += currInt;
            }
            prevInt = currInt;
        }
        return sum;
    }

    /**
     Helper function that takes in a single String roman and returns the int equivalent.
     **/
    public int helper(String roman) {
        int toReturn = 0;
        switch(roman) {
            case "I":
                toReturn = 1;
                break;
            case "V":
                toReturn = 5;
                break;
            case "X":
                toReturn = 10;
                break;
            case "L":
                toReturn = 50;
                break;
            case "C":
                toReturn = 100;
                break;
            case "D":
                toReturn = 500;
                break;
            case "M":
                toReturn = 1000;
                break;

        }
        return toReturn;
    }

    /**
     Helper function used to check the three exceptions to Roman numerals.
     Takes in two integers, prevInt and currInt, and uses them to check exceptions
     Returns true if exception is met, false otherwise.
     **/
    public boolean checkException(int prevInt, int currInt) {
        if (prevInt == 1) {
            return currInt == 5 || currInt == 10;
        } else if (prevInt == 10) {
            return currInt == 50 || currInt == 100;
        } else if (prevInt == 100) {
            return currInt == 500 || currInt == 1000;
        }
        return false;
    }

    public static void main(String[] args) {
        RomanToInteger tester = new RomanToInteger();
        String input1 = "III";
        System.out.println(tester.romanToInt(input1));
        String input2 = "LVIII";
        System.out.println(tester.romanToInt(input2));
        String input3 = "MCMXCIV";
        System.out.println(tester.romanToInt(input3));
    }
}
