class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ls = new ArrayList<>();

        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            ls.add(intervals[i]);
            i += 1;
        }
        
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i += 1;
        }

        ls.add(newInterval);

        while(i < n){
            ls.add(intervals[i]);
            i += 1;
        }

        return ls.toArray(new int[ls.size()][]);
    }
}