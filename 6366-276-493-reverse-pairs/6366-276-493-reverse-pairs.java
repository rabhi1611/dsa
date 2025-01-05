class Solution {
    private int merge(int[] arr, int l, int mid, int r){
        int i = l;
        int n = mid;

        int j = mid + 1;
        int m = r;

        // merge logic

        int temp[] = new int[r - l + 1];
        int t = 0;

        while(i <= n && j <= m){
            if(arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            } else{
                temp[t++] = arr[j++];
            }
        }

        while(i <= n){
            temp[t++] = arr[i++];
        }

        while(j <= m){
            temp[t++] = arr[j++];
        }

        // count reverse pairs
        int cnt = 0;
        j = mid + 1;
        for(int k = l; k <= n; k++){
            while(j <= m && arr[k] > 2 * (long)arr[j]){
                j++;
            }
            cnt += ((long)j - (mid + 1));
        }

        t = 0;
        while(l <= r){
            arr[l++] = temp[t++];
        }

        return cnt;
    }

    private int mergeSort(int[] arr, int l, int r){

        if(l >= r)   return 0;

        int mid = (l + r) / 2;

        int sa1 = mergeSort(arr, l, mid);
        int sa2 = mergeSort(arr, mid + 1, r);

        int cnt = merge(arr, l, mid, r);

        return sa1 + sa2 + cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}