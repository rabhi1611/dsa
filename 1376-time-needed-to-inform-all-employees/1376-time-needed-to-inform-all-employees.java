class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i += 1){
            if(manager[i] == -1) continue;
            List<Integer> ls = mp.getOrDefault(manager[i], new ArrayList<>());
            ls.add(i);
            mp.put(manager[i], ls);
        }

        //System.out.println(mp);

        int ans = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(headID);

        while(!q.isEmpty()){

            int size = q.size();
            int mans = Integer.MIN_VALUE;

            while(size > 0){
                int curr = q.poll();
                //System.out.println(curr);
                mans = Math.max(mans, informTime[curr]);

                if(mp.containsKey(curr)){
                    //ans += informTime[curr];
                    for(int i = 0; i < mp.get(curr).size(); i += 1){
                        q.add(mp.get(curr).get(i));    
                    }

                }
                
                size -= 1;
            }

            ans += mans;
        }

        return ans;
    }
}