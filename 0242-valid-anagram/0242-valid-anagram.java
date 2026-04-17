class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        int[] ch = new int[26];

        for(int i = 0; i < s.length(); i++){
            ch[s.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < t.length(); i++){
            if(ch[t.charAt(i) - 'a'] > 0)
                ch[t.charAt(i) - 'a'] -= 1;
            else
                return false;
        }

        return true;
    }
}