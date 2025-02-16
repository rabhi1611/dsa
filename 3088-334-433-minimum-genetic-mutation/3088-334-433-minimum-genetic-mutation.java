
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int ans = Integer.MAX_VALUE;

        Queue<String> q = new ArrayDeque<>();
        Set<String> st = new HashSet<>();   
        q.add(startGene);
        st.add(startGene);
        int level = -1;

        while(!q.isEmpty()){
            int limit = q.size();
            level += 1;

            if(level > bank.length){
                break;
            }

            while(limit > 0){
                String curr = q.poll();
            
                if(curr.equals(endGene)){
                    ans = Math.min(ans, level);     
                }

                for(int i = 0; i < bank.length; i++){
                    if(shouldAdd(curr, bank[i])){
                        if(!st.contains(bank[i])){
                            q.add(bank[i]);
                            st.add(bank[i]);
                        }
                    }
                }
                limit--;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean shouldAdd(String a, String b){
        int cnt = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }

        return cnt == 1 ? true : false;
    }
}