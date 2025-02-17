class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<String, Character> mp = new HashMap<>();
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        int[] presnt = new int[26];

        for(int i = 0; i < pattern.length(); i++){
            char p = pattern.charAt(i);
            String word = words[i];

            if(mp.containsKey(word)){
                if(!mp.get(word).equals(p)){
                    return false;
                }
            } else {
                if(presnt[p - 97] == 1){
                    return false;
                }
                mp.put(word, p);
                presnt[p - 97] = 1;
            }
        }

        return true;
    }
}