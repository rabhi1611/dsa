class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if(p.length() > s.length()){
            return ans;
        }
       
        Map<Character, Integer> pmp = new HashMap<>();

        for(char c: p.toCharArray()){
            pmp.put(c, pmp.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> smp = new HashMap<>();

        // first k
        for(int i = 0; i < p.length(); i++){
            char c = s.charAt(i);
            smp.put(c, smp.getOrDefault(c, 0) + 1);
        }

        if(smp.equals(pmp)){
            ans.add(0);
        }

        for(int i = p.length(); i < s.length(); i++){
            char c = s.charAt(i);
            // remove first char
            char firstChar = s.charAt(i - p.length()); 
            smp.put(firstChar, smp.get(firstChar) - 1);

            if(smp.get(firstChar) == 0){
                smp.remove(firstChar);
            }

            // add c
            smp.put(c, smp.getOrDefault(c, 0) + 1);

            if(smp.equals(pmp)){
                ans.add(i - p.length() + 1);
            }   
        }


        return ans;
    }
}