class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();
        int k = 0, i = 0;
        ans.add(new int[]{intervals[i][0], intervals[i][1]});

        i += 1;
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(intervals[i][0] <= ans.get(k)[1]){
                // merge
                ans.set(k, 
                new int[]{Math.min(ans.get(k)[0], start), Math.max(ans.get(k)[1], end)});
            } else {
                k += 1;
                ans.add(new int[]{start, end});
            }

            i += 1;
        }

        return ans.toArray(new int[0][]);
    }
}