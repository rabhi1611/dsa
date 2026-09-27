class Solution {
    // Global pointer to track current position in the string
    private Integer start = 0;

    // Main function to reverse substrings inside parentheses
    public String reverseParentheses(String s) {
        int n = s.length();
        // Call helper starting from the last index, convert result to String
        return helper(n - 1, s).toString();
    }

    // Recursive helper function to process the string
    private StringBuilder helper(int end, String s){
        // Stores the current processed substring
        StringBuilder finalAns = new StringBuilder();

        // Iterate until we reach the end of the string
        while(start <= end){
            // Case 1: Found an opening bracket '('
            if(s.charAt(start) == '('){
                start += 1; // Move past '('
                // Recursively process the substring inside parentheses
                StringBuilder subAns = helper(end, s);
                // Append the processed substring
                finalAns.append(subAns);

            // Case 2: Found a closing bracket ')'
            } else if(s.charAt(start) == ')'){
                // Reverse the current substring and return
                return finalAns.reverse();

            // Case 3: Normal character (not a bracket)
            } else {
                // Append character to result
                finalAns.append(s.charAt(start));
            }

            // Move to the next character
            start = start + 1;
        }

        // Return the fully processed substring
        return finalAns;
    }
}
