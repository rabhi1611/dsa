class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s: tokens){
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                st.add(Integer.parseInt(s));
                continue;
            }

            int b = st.pop(), a = st.pop(); 
            //System.out.printf(" %d %d \n", a, b);

            if(s.equals("+")){
                st.add(a + b);
                continue;
            }

            
            if(s.equals("-")){
                st.add(a - b);
                continue;
            }

            
            if(s.equals("*")){
                st.add(a * b);
                continue;
            }

            st.add(a / b);
        }


        return st.pop();
    }
}