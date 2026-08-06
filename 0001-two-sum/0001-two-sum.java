class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();

        //filling the hashmap
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        //searching 

        for(int i = 0; i<nums.length;i++){
            int num = nums[i];
            int rem = target - num;
            if( map.containsKey(rem)){
                int idex = map.get(rem);
                if(idex==i)continue;
                return new int[]{i,idex};
            }
           
        }
        return new int[]{};
    }
}