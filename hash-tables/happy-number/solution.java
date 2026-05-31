class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sumCheck = new HashSet<>();
        return isHappyHelper(n, sumCheck);
    }

    public boolean isHappyHelper(int n, Set<Integer> sumCheck) { 
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 2);
            n /= 10; 
        }
        if (sum == 1) return true;
        if (sumCheck.contains(sum)) return false;
        else sumCheck.add(sum);
        return isHappyHelper(sum, sumCheck);
    }
}