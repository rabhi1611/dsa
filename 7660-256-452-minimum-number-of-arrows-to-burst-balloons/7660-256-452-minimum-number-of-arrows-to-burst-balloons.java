class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        int ta = points[0][0];
        int tb = points[0][1];

        int cnt = 1;

        int i = 1;
        while(i < n){
            if(points[i][0] <= tb){
                ta = Math.max(ta, points[i][0]);
                tb = Math.min(tb, points[i][1]);
            } else {
                cnt++;
                ta = points[i][0];
                tb = points[i][1];
            }
            i++;
        }

        return cnt;
    }
}