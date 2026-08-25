class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            // Maximum subarray sum (Kadane's Algorithm)
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray sum (Modified Kadane's Algorithm)
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // Handle case where all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the maximum of non-wrapped (maxSum) and wrapped (totalSum - minSum)
        return Math.max(maxSum, totalSum - minSum);
    }
}