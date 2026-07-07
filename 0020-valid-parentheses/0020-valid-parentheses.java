class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i += 1){
            Character chl = s.charAt(i);
            
            if(chl == '(' || chl == '[' || chl == '{'){
                st.push(chl);
            } else {
                if(st.isEmpty()){
                    return false;
                }

                char chr = st.peek();

                if(chl == ')'){
                    if(chr != '('){
                        return false;
                    }
                } else if (chl == '}'){
                    if(chr != '{'){
                        return false;
                    }
                } else {
                    if(chr != '['){
                        return false;
                    }
                }

                if(!st.isEmpty())   st.pop();
            }
        }

        if(!st.empty()) return false;

        return true;
    }
}