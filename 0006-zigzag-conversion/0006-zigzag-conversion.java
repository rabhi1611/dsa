class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if(numRows == 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int limit = 2 * (numRows - 1);

        for(int i = 0; i < numRows; i += 1){
            int j = i;
            while(j < n){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1){
                    int nidx = (j + limit - (2 * i));
                    if(nidx < n){
                        sb.append(s.charAt(nidx));
                    }
                }

                j += limit;
            }
        }

        return sb.toString();
    }
}