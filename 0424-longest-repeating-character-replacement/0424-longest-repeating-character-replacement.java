class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = 0;

        int ans = 0;

        int[] freq = new int[26];

        while(r < s.length()){
            char chr = s.charAt(r);
            freq[chr - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[chr - 'A']);

            while((r - l + 1) - maxFreq > k){
                char chl = s.charAt(l);
                freq[chl - 'A'] -= 1;

                for(int i = 0; i < 26; i += 1){
                    maxFreq = Math.max(maxFreq, freq[i]);
                }

                l += 1;
            }

            ans = Math.max(ans, (r - l + 1));

            r += 1;
        }

        return ans;
    }
}