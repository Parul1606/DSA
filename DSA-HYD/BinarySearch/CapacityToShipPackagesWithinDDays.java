class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int lo = max;
        int hi = sum;
        while(lo < hi){
            int thWt = lo + (hi - lo)/2;
            boolean res = areWeAbleToShip(weights, thWt, days);
            if(res == true){
                hi = thWt;
            }else{
                lo = thWt + 1;
            }
        }
        return hi;
    }


    public boolean areWeAbleToShip(int [] weights, int thWt, int days){
        int dayCount = 1;
        int pickedWt = 0;
        int i = 0;
        while(i < weights.length){
            if(pickedWt + weights[i] <= thWt){
                pickedWt += weights[i];
                i++;
            }else{
                dayCount++;
                pickedWt = weights[i];
                i++;
            }
        }
        return dayCount <= days;

    }
}
