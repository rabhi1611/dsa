class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            while(!st.isEmpty() && k > 0 && num.charAt(i) < st.peek()){
                st.pop();
                k--;
            }
            
            st.push(num.charAt(i));
        }
        
        StringBuilder res = new StringBuilder();
        
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        res.reverse();
        
        while(k > 0 && res.length() != 0){
            res.deleteCharAt(res.length() - 1);
            k--;
        }
        
        while(res.length() != 0 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        
        if(res.isEmpty()){
            return "0";
        }
     
        return res.toString();
    }
}