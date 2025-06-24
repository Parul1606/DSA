class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int jLeft = mid - 1 >= 0 ? arr[mid - 1] : Integer.MIN_VALUE;
            int jRight = mid + 1 < arr.length ? arr[mid + 1] : Integer.MIN_VALUE;
            if(jLeft < arr[mid] && arr[mid] > jRight){
                return mid;
            }else if(jLeft > arr[mid] && arr[mid] > jRight){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return -1;
    }
}
