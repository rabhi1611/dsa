class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;

        List<int[]> ls = new ArrayList<>();

        int i = 0, j = 0;
        while(i < n && j < m){
            int[] a = firstList[i];
            int[] b = secondList[j];

            int[] temp = new int[2];
            temp[0] = Math.max(a[0], b[0]);
            temp[1] = Math.min(a[1], b[1]);

            if(temp[1] >= temp[0]){
                ls.add(temp);
            }

            if(a[1] > b[1]){
                j++;
            } 
            else {
                i++;
            }
        }

        return ls.toArray(new int[0][]);
    }
}