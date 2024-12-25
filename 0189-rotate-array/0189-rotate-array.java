class Solution {
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        
        List<Integer> ls = new ArrayList<>();
        
        for(int i = n - d; i < n; i++){
            ls.add(arr[i]);
        }
        
        for(int i = n - d - 1; i >= 0; i--){
            arr[i + d] = arr[i];
        }
        
        for(int i = 0; i < d; i++){
            arr[i] = ls.get(i);
        }
        
    }
}