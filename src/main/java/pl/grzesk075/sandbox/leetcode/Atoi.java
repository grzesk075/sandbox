package pl.grzesk075.sandbox.leetcode;

public class Atoi {

    /**
     * To do the solution faster we can use:  int digit = c - '0'; result = result * 10 + tmp;
     */
    class Solution {

        public static final int ERROR_RESULT = 0;

        public int myAtoi(String str) {

            if (str == null) {
                return ERROR_RESULT;
            }
            boolean signed = false;
            boolean negative = false;
            boolean containsAnyDigit = false;
            StringBuilder intStrBuff = new StringBuilder();
            strLoop:
            for (char c : str.toCharArray()) {
                switch (c) {
                    case ' ':
                        if (signed || containsAnyDigit) {
                            break strLoop;
                        }
                        break;
                    case '-':
                        negative = true;
                    case '+':
                        if (containsAnyDigit) {
                            break strLoop;
                        }
                        if (signed) {
                            return ERROR_RESULT;
                        }
                        signed = true;
                        intStrBuff.append(c);
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        containsAnyDigit = true;
                        intStrBuff.append(c);
                        break;
                    default:
                        break strLoop;
                }
            }
            final String intStr = intStrBuff.toString();
            if (intStr.isEmpty() || !containsAnyDigit) {
                return ERROR_RESULT;
            }
            try {
                return Integer.parseInt(intStr);
            } catch (NumberFormatException e) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
    }
}
