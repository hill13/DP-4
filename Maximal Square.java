// Time complexity : O(m * n)
// Space Complexity : O(n)
// Did the code successfully run on Leetcode: Yes
// Approach:
//  Use a 1D array where dp[j] stores the size of the largest square ending at (i,j)
// Traverse from bottom- right to top-left, using extra variable 'diagDown' to track the diagonal value
// At each '1', update the dp[j] = 1 + min(right, down, diagonal); track the maximum square side to return area

class Solution {
    public int maximalSquare(char[][] matrix) {
       int m = matrix.length;
       int n = matrix[0].length;

       int max = 0;
       int [][]dp =new int [m+1][n+1];

       for(int i = m-1; i>=0; i--){
        for ( int j = n-1; j >=0; j--){
            if( matrix[i][j] == '1' ){
                dp[i][j] = 1+ Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                max = Math.max(dp[i][j], max);
            }
        }
       }
       return max * max; 
    }
}