class Solution {
    public int pivotIndex(int[] nums) {
        int [] psum = new int[nums.length];
        psum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            psum[i] = psum[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            int leftSum = i-1 >= 0 ? psum[i-1] : 0;
            int rightSum = psum[nums.length - 1] - psum[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}
