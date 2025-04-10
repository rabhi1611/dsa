class Solution {
    private List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        int n = s.length();

        StringBuilder ctr = new StringBuilder();
        helper(0, n, s, ctr);
        return ans;
    }

    private void helper(int i, int n, String s, StringBuilder ctr){
        if(i == n){
            ans.add(new StringBuilder(ctr).toString());
            return;
        }

        char c = s.charAt(i);

        ctr.append(c);
        helper(i + 1, n, s, ctr);
        ctr.setLength(ctr.length()- 1);

        if(c >= '0' && c <= '9'){
            return;
        }

        if(c >= 'A' && c <= 'Z'){
            ctr.append((char)(c + 32));
            System.out.println(c + 32);
        } else {
            ctr.append((char)(c - 32));
        }
        
        helper(i + 1, n, s, ctr);
        ctr.setLength(ctr.length()- 1);

        return;
    }
}