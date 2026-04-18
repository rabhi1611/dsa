class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> mp = new HashMap<>();

        for(int i = 0; i < n; i += 1){
            int[] count = new int[26];

            for(int j = 0; j < strs[i].length(); j += 1){
                count[strs[i].charAt(j) - 'a'] += 1;
            }

            StringBuilder key = new StringBuilder();
            for(int j = 0; j < 26; j += 1){
                key.append(count[j]).append('#');
            }
            
            List<String> t = mp.getOrDefault(key.toString(), new ArrayList<>());
            t.add(strs[i]);
            mp.put(key.toString(), t);
        }


        return new ArrayList<>(mp.values());
    }
}