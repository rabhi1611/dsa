class Solution {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        helper(0, n, s, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, int n, String s, List<String> bkt){
        if(idx == n){
            ans.add(new ArrayList<>(bkt));
            return;
        }

        StringBuilder ts = new StringBuilder();
        
        for(int i = idx; i < n; i++){
            ts.append(s.charAt(i));
            if(isPalindrome(ts)){
                bkt.add(ts.toString());
                helper(i + 1, n, s, bkt);
                bkt.remove(bkt.size() - 1);
            }
        }
    }

    private boolean isPalindrome(StringBuilder s){
        String ts = s.toString();

        int i = 0, j = ts.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }

            i += 1;
            j -= 1;
        }

        return true;
    }
}