class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int add = 0;
            if (charArray[i] == 'I') {
                if (i + 1 < charArray.length && (charArray[i + 1] == 'V' || charArray[i + 1] == 'X')) {
                    add = -1;
                } else {
                    add = 1;
                }
            }
            if (charArray[i] == 'V') add = 5;
            if (charArray[i] == 'X') {
                if (i + 1 < charArray.length && (charArray[i + 1] == 'L' || charArray[i + 1] == 'C')) {
                    add = -10;
                } else {
                    add = 10;
                }
            }
            if (charArray[i] == 'L') add = 50;
            if (charArray[i] == 'C') {
                if (i + 1 < charArray.length && (charArray[i + 1] == 'D' || charArray[i + 1] == 'M')) {
                    add = -100;
                } else {
                    add = 100;
                }
            }
            if (charArray[i] == 'D') add = 500;
            if (charArray[i] == 'M') add = 1000;

            sum += add;
        }
        return sum;
    }
}
