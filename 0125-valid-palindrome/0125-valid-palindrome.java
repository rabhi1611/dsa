class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for(char c: s.toCharArray()){
            char ch =  Character.toLowerCase(c);
            if(!((ch >= 97 && ch <= 122)
                || (ch >= 48 && ch <= 57))){
                    continue;
            }
            str.append(ch);
        }

        int i = 0, j = str.length() - 1;

        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }

            i += 1;
            j -= 1;
        }
        
        return true;
    }
}