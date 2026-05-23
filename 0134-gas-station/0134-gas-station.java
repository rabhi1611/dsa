class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tGas = 0, tCost = 0;

        for(int i = 0; i < n; i += 1){
            tGas += gas[i];
            tCost += cost[i];
        }

        if(tGas < tCost)    return -1;

        int pos = 0, currGas = 0; 

        for(int i = 0; i < n; i += 1){
            currGas += (gas[i] - cost[i]);

            if(currGas < 0){
                currGas = 0;
                pos = i + 1;
            }
        }

        return pos;
    }
}