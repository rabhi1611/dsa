class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i += 1){
            Character ch = s.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            } else {
                if(ch == ')'){
                    if(st.isEmpty() || st.peek() != '('){
                        return false;
                    }
                } else if (ch == '}'){
                    if(st.isEmpty() || st.peek() != '{'){
                        return false;
                    }
                } else {
                    if(st.isEmpty() || st.peek() != '['){
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