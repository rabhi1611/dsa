class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> mp = new HashMap<>();
        
        for(String str: strs){
            char[] ar = str.toCharArray();
            Arrays.sort(ar);
            String ts = String.valueOf(ar); 
            List<String> tls = mp.getOrDefault(ts, new ArrayList<>());
            tls.add(str);
            mp.put(ts, tls);
        }


        mp.entrySet().stream().forEach(value -> ans.add(value.getValue()));
        return ans;
    }
}