class Solution {
    public int missingMultiple(int[] nums, int k) {
        int m = k;

        while(true){
            boolean f = false;

            for(int num : nums){
                if(num== m){
                    f = true;
                    break;
                }
            }
            if(!f){
                return m;
            }
            m +=k;
        }
    }
}