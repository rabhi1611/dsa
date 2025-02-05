class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        StringBuilder ans = new StringBuilder();

        Stack<String> st = new Stack<>();

        int i = 0;
        while(i < n){
            char c = path.charAt(i);

            if(c == '/'){
                i++;
            }
            else {
                StringBuilder t = new StringBuilder();
                char tc = c;
                while(tc != '/'){
                    t.append(tc);
                    i++;
                    if(i >= n)   break;
                    tc = path.charAt(i);
                }
                if(allDot(t.toString())){
                    if(t.length() == 2){
                        if(!st.isEmpty())   st.pop();
                    } else if(t.length() > 2) st.add(t.toString());
                } 
                else
                    st.add(t.toString());
            }
        }

        Stack<String> fst = new Stack<>();

        while(!st.isEmpty()){
            fst.add(st.pop());
        }

        if(fst.isEmpty()){
            ans.append("/");
            return ans.toString();
        }

        while(!fst.isEmpty()){
            ans.append("/");
            ans.append(fst.pop());
        }       

        return ans.toString();
    }


    private Boolean allDot(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '.'){
                return false;
            }
        }
        return true;       
    }
}