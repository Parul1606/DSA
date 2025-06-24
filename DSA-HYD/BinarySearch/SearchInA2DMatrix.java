class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {
        int lo = 0;
        int hi = arr.length - 1;
        int ansRow = -1;
        // log(n)
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid][0] <= tar && arr[mid][arr[0].length - 1] >= tar){
                ansRow = mid;
                break; 
            }else if(tar < arr[mid][0]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        if(ansRow == -1){
            return false;
        }

        lo = 0;
        hi = arr[0].length - 1;
        // log(m)
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            if(arr[ansRow][mid] < tar){
                lo = mid + 1;
            }else if(arr[ansRow][mid] > tar){
                hi = mid - 1;
            }else{
                return true;
            }
        }
        //log(n*m) = `10^5*10^5 -> 10^10 -> 10
        //log(n + m) = 10^5 + 10^5 -> 2*10^5 -> 5

        if(arr[ansRow][lo] == tar){
            return true;
        }
        return false;



    }
}
