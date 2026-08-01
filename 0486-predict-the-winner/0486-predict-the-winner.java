class Solution {

    private Integer[][] memo;

    
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        memo = new Integer[n][n];
        return solve(nums,0,n-1) >=0;
    }

    private int solve(int[] nums, int left, int right){
        if(left == right){
            return nums[left];

        }

        if(memo[left][right]!=null){
            return memo[left][right];

        }

        int pickleft = nums[left]-solve(nums,left+1,right);

        int pickright =nums[right] - solve(nums,left,right-1);

        memo[left][right] = Math.max(pickleft,pickright);

        return memo[left][right];
    }
}