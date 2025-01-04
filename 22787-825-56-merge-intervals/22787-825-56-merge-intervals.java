class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        int[] a = intervals[0];

        for(int i = 1; i < n; i++){
            int[] b = intervals[i];

            if(b[0] <= a[1]){
                // merge
                if(a[0] > b[0]){
                    a[0] = b[0];
                }

                if(a[1] < b[1]){
                    a[1] = b[1];
                } 
            } else {
                ans.add(List.of(a[0], a[1]));
                 a = b;
            }
        }


        ans.add(List.of(a[0], a[1]));

        return ans.stream().map(x -> x.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
        //return intervals;
    }
}