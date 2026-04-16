class Solution {
    private int ans = 0;

    private boolean filledProperly(int maxCapacityPerDay, int[] weights, int days){
        //System.out.println(maxCapacityPerDay);
        int currentCapacityPerDay = 0;

        int i = 0;
        while(i < weights.length){
            if(currentCapacityPerDay + weights[i] > maxCapacityPerDay){
                // can't be filled in current day
                days -= 1;
                currentCapacityPerDay = 0;
            } 

            currentCapacityPerDay += weights[i];

            if(currentCapacityPerDay > maxCapacityPerDay){
                return false;
            }
            i += 1;
        }

        if(days <= 0){
            return false;
        }

        return true;
    }

    private void helper(int left, int right, int[] weights, int days){
        if(left > right){
            return;
        }

        int mid = (left + right) / 2;

        if(filledProperly(mid, weights, days)){
            ans = mid;
            helper(left, mid - 1, weights, days);
        }else{
            helper(mid + 1, right, weights, days);
        }
    } 

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = Integer.MAX_VALUE;
        helper(left, right, weights, days);
        return ans;
    }
}