class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n != m){
            return -1;
        }

        int xyCount = 0, yxCount = 0;

        for(int i  = 0; i < n; i += 1){
            if(s1.charAt(i) == 'x' && s2.charAt(i) == 'y'){
                xyCount += 1;
            } else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x'){
                yxCount += 1;
            }
        }

        if(xyCount % 2 == 0 && yxCount % 2 == 0){
            return (xyCount / 2 + yxCount / 2);
        } else if (xyCount % 2 == 1 && yxCount % 2 == 1){
            return (xyCount / 2 + yxCount / 2) + 2;
        } else {
            return -1;
        }
    }
}