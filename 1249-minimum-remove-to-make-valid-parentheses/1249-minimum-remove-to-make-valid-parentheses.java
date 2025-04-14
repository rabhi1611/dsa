class Pair {
    Character c;
    Integer cIndx;

    Pair (Character c, Integer cIndx){
        this.c = c;
        this.cIndx = cIndx;
    }
}


class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();

        Set<Integer> set = new HashSet<>();
        Stack<Pair> st = new Stack<>();

        for(int i = 0; i < n; i++){
            Character sc = s.charAt(i);

            if(sc == '('){
                st.add(new Pair(sc, i));
            } else if (sc == ')'){
                if(st.isEmpty()){
                    // push 
                    set.add(i);
                } else {
                    st.pop();
                }
            }
        }

        while(!st.isEmpty()){
            set.add(st.pop().cIndx);
        }


        String ans = "";
        for(int i = 0; i < n; i++){
            Character sc = s.charAt(i);
            if(!set.contains(i)){
                ans += sc;
            }
        }

        return ans;
    }
}