class Solution {
    public int search(int[] arr, int tar) {
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

        if(tar >= arr[0] && tar > arr[arr.length - 1]){
            lo = 0;
            hi = hi - 1;
        }else{
            lo = lo;
            hi = arr.length - 1;
            
        }
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == tar){
                return mid;
            }else if(arr[mid] > tar){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return -1;

    }
}
