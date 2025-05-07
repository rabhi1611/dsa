class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<Integer> countSt = new Stack<>();
        Stack<Character> charSt = new Stack<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(!charSt.isEmpty() && charSt.peek() == c){
                countSt.push(countSt.peek() + 1);
            }else{
                countSt.push(1);
            }

            charSt.push(c);

            if(countSt.peek() == k){
                for(int j = 0; j < k; j++){
                    charSt.pop();
                    countSt.pop();
                }
            }
        }


        StringBuilder ans = new StringBuilder();
        while(!charSt.isEmpty()){
            ans.append(charSt.pop());
        }

        ans.reverse();
        return ans.toString();
    }
}