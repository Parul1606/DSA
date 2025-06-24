// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        
        Arrays.sort(stalls);
        int lo = 1;
        int hi = stalls[stalls.length - 1] - stalls[0];
        int ans = Integer.MIN_VALUE;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(areWeAbleToPlaceCows(stalls, mid, k) == true){
                lo = mid + 1;
                ans = Math.max(mid, ans);
            }else{
                hi = mid - 1;
            }
        }
        return ans;
        
    }
    
    
    public static boolean areWeAbleToPlaceCows(int [] arr, int minDis, int k){
        int lastCowIdx = 0;
        int cowCount = 1;
        int idx = 1;
        while(idx < arr.length){
            int diff = arr[idx] - arr[lastCowIdx];
            if(diff >= minDis){
                lastCowIdx = idx;
                cowCount++;
            }
            idx++;
        }
        return cowCount >= k;
    }
}
