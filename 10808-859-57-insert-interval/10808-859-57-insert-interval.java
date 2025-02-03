class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] newArray = new int[intervals.length + 1][];
		for (int i = 0; i < intervals.length; i++)
			newArray[i] = intervals[i];
		newArray[intervals.length] = newInterval;
		Arrays.sort(newArray, Comparator.comparingInt(i -> i[0]));
		LinkedList<int[]> merged = new LinkedList<int[]>();
		for (int[] i : newArray) {
			if (!merged.isEmpty() && merged.getLast()[1] >= i[0])
				merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
			else 
                merged.add(i);
		}
		return merged.toArray(new int[0][]);
    }
}