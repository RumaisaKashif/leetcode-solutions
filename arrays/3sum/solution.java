class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int m = 0; m < len - 2; m++) {
            // Skip duplicates of target (first number)
            if (m > 0 && nums[m] == nums[m - 1]) { 
                continue;
            }
            int i = m + 1; // Start right after m to avoid duplicating nums[m]
            int j = len - 1; // Start from the end
            int target = nums[m];
            while (i < j) { 
                int sum = nums[i] + nums[j];
                if (sum == -target) { 
                    result.add(Arrays.asList(nums[i], nums[j], target));
                    // Remove duplicates of sortedNums[i]
                    while (i < j && nums[i] == nums[i + 1]) { 
                        i++;
                    }
                    // Remove duplicates of sortedNums[j]
                    while (i < j && nums[j] == nums[j - 1]) { 
                        j--;
                    }

                    i++;
                    j--;
                } else if (sum < -target) { 
                    i++;
                } else {
                    j--;
                }
            }
        }  
        return result;  
    }
}