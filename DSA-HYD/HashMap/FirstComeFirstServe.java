// User function Template for Java

class Solution {

    static int firstElement(int arr[], int k) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(map.get(arr[i]) == k){
                return arr[i];
            }
        }
        
        return -1;
    }
}
