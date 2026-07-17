class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        // sort the array
        Arrays.sort(arr);

        // find minimum diff
        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < n; i += 1){
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // create a record
        Map<Integer, Boolean> rec = new HashMap<>();

        for(int i = 0; i < n; i += 1){
            if(rec.containsKey(arr[i] - minDiff)){
               ans.add(List.of(arr[i] - minDiff, arr[i])); 
            }

            rec.put(arr[i], true);
        }

        return ans;
    }
}