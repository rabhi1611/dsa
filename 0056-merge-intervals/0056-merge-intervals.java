class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        List<List<Integer>> ls = new ArrayList<>();

        int i = 0, j = 1;

        int bl = intervals[i][0];
        int br = intervals[i][1];

        while(j < n){
            if(br < intervals[j][0]){
                ls.add(new ArrayList<>(List.of(bl, br)));

                i += 1;
                bl = intervals[i][0];
                br = intervals[i][1];
                j += 1;
                continue;
            }

            // merge
            bl = Math.min(bl, intervals[j][0]);
            br = Math.max(br, intervals[j][1]);

            i += 1;
            j += 1;            
        }

        ls.add(new ArrayList<>(List.of(bl, br)));

        return ls.stream().map(row -> row.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}