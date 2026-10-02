class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        helper(open, close, new StringBuilder());
        return result;
    }

    private void helper(int open, int close, StringBuilder container){
        if(open == 0 && close == 0){
            result.add(new StringBuilder(container).toString());
            return;
        }

        if(open >= 0){
            // open
            container.append("(");
            helper(open - 1, close, container);
            container.setLength(container.length() - 1);
        }
        
        if(close >= 0 && open < close){
            // close
            container.append(")");
            helper(open, close - 1, container);
            container.setLength(container.length() - 1);
        }
    }
}