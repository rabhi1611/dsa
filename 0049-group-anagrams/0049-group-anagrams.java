class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();

        for(String s: strs){
            StringBuilder key = new StringBuilder();
            
            int[] freq = new int[26];
            
            for(char c: s.toCharArray()){
                freq[c - 'a'] += 1;
            }

            for(int i = 0; i < 26; i += 1){
                key.append(freq[i]);
                key.append("#");
            }

            List<String> rec = mp.getOrDefault(key.toString(), new ArrayList<>());
            rec.add(s);

            mp.put(key.toString(), rec);
        }

        mp.entrySet().stream().forEach(es -> {
            ans.add(es.getValue());
        });

        return ans;
    }
}