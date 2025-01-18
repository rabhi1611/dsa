class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int n = nums.length;

        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            int num = nums[i];

            for(int j = 2; (j * j) <= num; j++){
                if(num % j == 0){
                    st.add(j);
                    while(num % j == 0){
                        num = num / j;
                    }
                }
            }

            if(num != 1)    st.add(num);
        }

        return st.size();
    }
}