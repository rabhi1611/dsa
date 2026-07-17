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


        // collect pairs
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                ans.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return ans;
    }
}