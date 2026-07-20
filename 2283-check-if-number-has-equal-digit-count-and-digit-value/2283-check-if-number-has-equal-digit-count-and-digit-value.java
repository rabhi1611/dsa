class Solution {
    public boolean digitCount(String num) {
        int n = num.length();
        int[] freq = new int[10];


        for(char c: num.toCharArray()){
            freq[c - '0'] += 1;
        }

        for(int i = 0; i < n; i += 1){
            if(freq[i] != (num.charAt(i) - '0')){
                return false;
            }
        }

        return true;
    }
}