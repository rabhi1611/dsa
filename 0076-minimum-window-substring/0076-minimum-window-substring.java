class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, count = 0, sidex = -1, minlen = Integer.MAX_VALUE, m = t.length();

        Map<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < t.length(); i++) mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0) + 1);

        while(r < s.length())
        {
            if(mp.getOrDefault(s.charAt(r), 0) > 0){
                count += 1;
            }

            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) - 1);

            while(count == m){
                if(r - l + 1 < minlen){
                    minlen = r - l + 1;
                    sidex = l;
                }
                mp.put(s.charAt(l), mp.get(s.charAt(l)) + 1);
                if(mp.get(s.charAt(l)) > 0) count = count - 1;
               l++;
            }

            r++;
        }

        return sidex == -1 ? "" : s.substring(sidex, sidex + minlen);
    }
}