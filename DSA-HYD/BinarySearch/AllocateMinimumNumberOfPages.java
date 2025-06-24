
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int lo = -1;
        int hi = 0;
        if(k > arr.length){
            return -1;
        }
        for(int i = 0; i < arr.length; i++){
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(canWeAllocatePages(arr, mid, k) == true){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return hi;
    }
    
    
    public static boolean canWeAllocatePages(int [] arr, int max, int k){
        int cS = 1;
        int sum = 0;
        int i = 0;
        while(i < arr.length){
            if(sum + arr[i] <= max){
                sum += arr[i];
                i++;
            }else{
                cS++;
                sum = arr[i];
                i++;
            }
        }
        return cS <= k;
    }
}
