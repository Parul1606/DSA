class Solution {
    public int subarraySum(int[] nums, int k) {
        int [] pSum = new int[nums.length];
        pSum[0]= nums[0];
        for(int i = 1; i < nums.length; i++){
            pSum[i] = pSum[i-1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int j = 0; j < pSum.length; j++){
            int pSumi = pSum[j] - k;
            if(map.containsKey(pSumi)){
                count += map.get(pSumi);
            }
            map.put(pSum[j], map.getOrDefault(pSum[j], 0) + 1);
        }
        return count;
    }
}
