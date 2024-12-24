class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s1.length() -                 s2.length());
        return nums[nums.length - k];
    }
}