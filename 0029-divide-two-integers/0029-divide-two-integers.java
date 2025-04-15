class Solution {
    public int divide(int c, int d) {
        if(c==-2147483648&&d==-1){
            return 2147483647;
        }
        return c/d;
    }
}