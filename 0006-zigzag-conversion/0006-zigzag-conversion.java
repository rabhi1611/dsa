class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();

        if(numRows == 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int limit = 2 * (numRows - 1);

        for(int i = 0; i < numRows; i += 1){
            if(i == 0 || i == numRows - 1){
                int j = i;
                while(j < n){
                    sb.append(s.charAt(j));
                    j += limit;
                }
            }else{
                int j = i;
                while(j < n){
                    sb.append(s.charAt(j));
                    if((j + limit - (2 * i)) < n){
                        sb.append(s.charAt((j + limit - (2 * i))));
                    }
                    j += limit;
                }
            }
        }

        return sb.toString();
    }
}