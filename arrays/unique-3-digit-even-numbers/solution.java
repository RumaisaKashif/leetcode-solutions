class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int i = 0; i < digits.length; i++) { // Hundreds place
            if (digits[i] == 0) continue; // Can't begin with 0
            for (int j = 0; j < digits.length; j++) { // Tens place
                if (j == i) continue; // Don't reuse same digit, check index
                for (int k = 0; k < digits.length; k++) { // Units place
                    if (k == i || k == j) continue; // Don't reuse same digit
                    if (digits[k] % 2 == 0) { // Even?
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        uniqueNums.add(number);
                    }
                }
            }
        }
        return uniqueNums.size();
    }
}
