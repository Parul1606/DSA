class Solution {
    public int findMin(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] > arr[hi]){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return arr[lo];
    }
}
