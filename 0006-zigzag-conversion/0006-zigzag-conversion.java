class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows > s.length()){
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        int row = 0;
        Boolean goDown = false;

        for(char c: s.toCharArray()){
            rows[row].append(c);

            if(row == 0 || row == numRows - 1){
                goDown = !goDown;
            }

            row += (goDown == true ? 1 : -1); 
        }

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < rows[i].length(); j++){
                res.append(rows[i].charAt(j));
            }
        }

        return res.toString();
    }
}