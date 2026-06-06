class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n){
            return false;
        }

        Map<Character, Integer> mp1 = new HashMap<>();
        
        for(int i = 0; i < m; i += 1){
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> mp2 = new HashMap<>();
        
        int l = 0, r = 0;

        while(r < n){
            // shrink the window
            if((r - l + 1) > m){
                char leftChar = s2.charAt(l);
                mp2.put(leftChar, mp2.getOrDefault(leftChar, 0) - 1);
                if(mp2.get(leftChar) <= 0){
                    mp2.remove(leftChar);
                }
                l += 1;
            }

            // expand the window
            char rightChar = s2.charAt(r);
            mp2.put(rightChar, mp2.getOrDefault(rightChar, 0) + 1);

            if((r - l + 1) == m){
                if(mp1.equals(mp2)) return true;
            }
            r += 1;
        }

        return false;
    }
}