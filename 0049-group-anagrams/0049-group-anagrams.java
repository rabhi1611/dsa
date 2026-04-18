class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> mp = new HashMap<>();

        for(int i = 0; i < n; i += 1){
            int[] counts = new int[26];

            for(char c: strs[i].toCharArray()){
                counts[c - 97] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for(int count: counts){
                sb.append(count).append("#");
            }

            String key = sb.toString();

            List<String> t = mp.getOrDefault(key, new ArrayList<>());
            t.add(strs[i]);
            mp.put(key, t);
        }


        return new ArrayList<>(mp.values());
    }
}