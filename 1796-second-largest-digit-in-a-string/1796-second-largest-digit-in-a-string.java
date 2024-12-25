class Solution {
    public int secondHighest(String s) {
        char slar = 'a';
        char lar = 'a';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if((c >= 48 && c <= 57) && lar == 'a'){
                lar = c;
                continue;
            }
            
            if((c >= 48 && c <= 57) && c > lar){
                slar = lar;
                lar = c;
            }
            
            if((c >= 48 && c <= 57) && c < lar){
                if(slar == 'a' || c > slar){
                    slar = c;
                }
            }
        }
       
        return slar == 'a' ? -1 : slar -  48;
    }
}