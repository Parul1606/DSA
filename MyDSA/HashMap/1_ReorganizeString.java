class Solution {
    public class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
       HashMap<Character, Integer> map = new HashMap<>();

       for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
       }
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
       StringBuilder sb = new StringBuilder();

       for(char key: map.keySet()){
        int freq = map.get(key);
        pq.add(new Pair(key, freq));
       }

       Pair prev = null;
       while(pq.size() != 0){
        Pair rem = pq.remove();
        sb.append(rem.ch);
        rem.freq -= 1;
        if(prev != null){
            pq.add(prev);
        }
        if(rem.freq != 0){
            prev = rem;
        }else{
            prev = null;
        }
       }

       if(sb.length() != s.length()){
        return "";
       }
       return sb.toString();

    }
}
