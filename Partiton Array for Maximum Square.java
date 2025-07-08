// Time Complexity : O(n * k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : 
// Use bottom-up DP where dp[i] stores the maximum sum for the subarray arr[0 , ..,i]
// For each position i, try all partition sizes j from 1 to k, keeping track of the max in the window
// Update dp[i] by vhoosing the best among all valid partitions ending at i

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i =1 ; i< arr.length; i++){
            int max = arr[i];
            for(int j =1; j<=k && i-j +1 >=0; j++){
                //in
                int curr = arr[i-j+1];
                max = Math.max(max,curr);

                if(  i-j >=0){
                    dp[i] = Math.max( dp[i], max * j + dp[i-j]);
                }else{
                    dp[i] = Math.max(dp[i] , max*j);
                }
            }
        }
        return dp[arr.length - 1];
    }
}