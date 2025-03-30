class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        return helper(0, n, s);
    }


    private int helper(int i, int n, String s){
        if(i >= n){
            return 1;
        }
        
        /*if(i == n - 1){
            if((s.charAt(i) - 48) >= 1 && (s.charAt(i) - 57) <= 9){
                return 1;
            }
            return 0;
        }*/

        int sa1 = -1, sa2 = -1;

        String t =  "" + s.charAt(i);

        if(Integer.valueOf(t) >= 1 && Integer.valueOf(t) <= 9){
            sa1 = helper(i + 1, n, s);
        }

        if(i + 1 < n){
            t += s.charAt(i + 1); 
            if(Integer.valueOf(t) >= 10 && Integer.valueOf(t) <= 26){
                sa2 = helper(i + 2, n, s);
            }
        }

        if(sa1 == -1 && sa2 == -1){
            return 0;
        }

        else if(sa1 == -1){
            return sa2;
        }

        else if(sa2 == -1){
            return sa1;
        }

        return sa1 + sa2;
    }
}