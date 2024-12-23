class Solution {
    
    private void merge(int arr[], int l, int mid, int r){
        int i = l;
        int j = mid + 1;
        int n = mid;
        int m = r;
        
        int[] subSortedArray = new int[(n - i + 1) + (m - j + 1)];    
    
        int k = 0;
        while(i <= n && j <= m){
            if(arr[i] <= arr[j]){
                subSortedArray[k] = arr[i];
                i++;
            } else{
                subSortedArray[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(i <= n){
            subSortedArray[k] = arr[i];
            i++;
            k++;
        }
        
        while(j <= m){
            subSortedArray[k] = arr[j];
            j++;
            k++;
        }
            
        k = l;
        i = 0;
        while(k <= r){
            arr[k] = subSortedArray[i];
            k++;
            i++;
        }
        
        return;
    }
    private void sort(int arr[], int l, int r){
        
        if(l >= r){
            return;
        }
        
        int mid = (l + r) / 2;
        
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        
        merge(arr, l, mid, r);
        
        return;
    }
    
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
}