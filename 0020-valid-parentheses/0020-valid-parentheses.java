class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        int i = 0;
        while(i < n){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                if(st.isEmpty() || st.peek() != '('){
                    return false;
                }
                st.pop();
            } else if (ch == '}'){
                if(st.isEmpty() || st.peek() != '{'){
                    return false;
                }
                st.pop();
            } else if (ch == ']'){
                if(st.isEmpty() || st.peek() != '['){
                    return false;
                }
                st.pop();
            }else{
                st.push(ch);
            }

            i += 1;
        }

        if(!st.isEmpty()){
            return false;
        }

        return true;
    }
}