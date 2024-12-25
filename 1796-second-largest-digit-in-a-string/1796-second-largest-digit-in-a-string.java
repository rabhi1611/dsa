class Solution {
    public int secondHighest(String s) {
        
        // initialize dummy char
        char slar = 'a';
        char lar = 'a';
        
        // loop
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if((c >= 48 && c <= 57) && (lar == 'a' || c > lar)){
                slar = lar;
                lar = c;
            }
            
            if((c >= 48 && c <= 57) && c < lar && (slar == 'a' || c > slar)){
                    slar = c;
            }
        }
       
        // dummy ? return -1
        return slar == 'a' ? -1 : slar -  48;
    }
}