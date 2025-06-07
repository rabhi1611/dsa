class Pair {
    String word;
    Integer freq;

    Pair(String word, Integer freq){
        this.word = word;
        this.freq = freq;
    }
}


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        Map<String, Pair> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq == b.freq){
                return a.word.compareTo(b.word);
            }

            return b.freq - a.freq; 
        });

        for(String word: words){
            if(mp.containsKey(word)){
                // take from map and remove from priority queue
                Pair pp = mp.get(word);
                Pair cp = new Pair(word, pp.freq + 1);
                mp.put(word, cp);
                // add new one
                pq.remove(pp);
                pq.add(cp);
            } else {
                // put in map
                Pair cp = new Pair(word, 1);
                mp.put(word, cp);
                // add new one
                pq.add(cp);
            }
        }

        while(k > 0){
            ans.add(pq.poll().word);
            k -= 1;
        }

        return ans;
    }
}