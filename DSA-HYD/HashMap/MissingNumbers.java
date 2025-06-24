import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        HashMap<Integer, Integer> fMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            // if(fMap.containsKey(val) == true){
            //     fMap.put(val, fMap.get(val) + 1);
            // }else{
            //     fMap.put(val, 1);
            // }

            fMap.put(val, fMap.getOrDefault(val, 0) + 1); // n
        }
        HashMap<Integer, Integer> sMap = new HashMap<>();
        for(int i = 0; i < brr.length; i++){
            int val = brr[i];
            // if(sMap.containsKey(val) == true){
            //     sMap.put(val, sMap.get(val) + 1);
            // }else{
            //     sMap.put(val, 1);
            // }
            sMap.put(val, sMap.getOrDefault(val, 0) + 1);
        } // m

        ArrayList<Integer> li = new ArrayList<>();
        for(int val : sMap.keySet()){
            int freqS = sMap.get(val);
            int freqF = fMap.getOrDefault(val, 0);
            if(freqS != freqF){
                li.add(val);
            }
        } //m

        if(li.size() == 0){
            System.out.println(-1);
            return;
        }

        Collections.sort(li); // mlogm + m + n  + m 

        for(int val : li){
            System.out.print(val + " ");
        }


    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}
