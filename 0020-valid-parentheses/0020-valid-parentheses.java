class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i += 1){
            char c = s.charAt(i);

            if(c == ')'){
                if(st.isEmpty() || st.peek() != '('){
                    return false;
                }

                st.pop();
            } else if (c == '}'){
                if(st.isEmpty() || st.peek() != '{'){
                    return false;
                }

                st.pop();
            } else if (c == ']'){
                if(st.isEmpty() || st.peek() != '['){
                    return false;
                }

                st.pop();
            } else {
                st.push(c);
            }
        }

        if(!st.isEmpty()){
            return false;
        }


        return true;
    }
}