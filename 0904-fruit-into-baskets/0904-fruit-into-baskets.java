class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int ans = 0;
        int l = 0, r = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while(r < n){
            // expandimg
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);
            
            // shrinking  
            while(mp.size() > 2){
                mp.put(fruits[l], mp.get(fruits[l]) - 1);
                if(mp.get(fruits[l]) <= 0){
                    mp.remove(fruits[l]);
                }
                l += 1;
            }

            ans = Math.max(ans, (r - l + 1));
            
            r += 1;
        }

        return ans;
    }
}