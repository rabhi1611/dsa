class Solution {
    public String getHappyString(int n, int k) {
        List<String> ls = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        helper(n, 0, s, ls);
        if(k > ls.size()){
            return "";
        }
        return ls.get(k - 1);
    }
 
    private void helper(int n, int t, StringBuilder s, List<String> ls){
        if(t == n){
            ls.add(s.toString());
            return;
        }
 
        char[] cls = new char[]{'a', 'b', 'c'};
       
        if(s.isEmpty()){
            for(int i = 0; i < 3; i++){
                s.append(cls[i]);
                helper(n, t + 1, s, ls);
                s.setLength(s.length() - 1);
            }
        } else {
            char c = s.charAt(s.length() - 1);
            for(int i = 0; i < 3; i++){
                if(c != cls[i]){
                    s.append(cls[i]);
                    helper(n, t + 1, s, ls);
                    s.setLength(s.length() - 1);
                }
            }
        }
 
    }
}