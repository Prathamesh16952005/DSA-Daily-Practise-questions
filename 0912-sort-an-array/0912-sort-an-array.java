class Solution {
    public static void heapify(int[] nums,int i,int s){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxidx = i;
    if(left < s && nums[left]> nums[maxidx]){
        maxidx= left;
    }
    if(right < s && nums[right]> nums[maxidx]){
        maxidx = right;

    }

    if(maxidx!=i){
        int temp = nums[i];
        nums[i]= nums[maxidx];
        nums[maxidx] = temp;
        heapify(nums,maxidx,s);
    }

    } 
   
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = n/2;i>=0;i--){
            heapify(nums,i,n);
        }

        for(int i =n-1;i>0;i--){
            int temp = nums[0];
            nums[0]= nums[i];
            nums[i]=temp;
            heapify(nums,0,i);
        }
        return nums;
    }
}