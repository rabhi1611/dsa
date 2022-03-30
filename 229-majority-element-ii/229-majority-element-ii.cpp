class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        // There will we only 2 nums in the array with occurance more than (n/3)
        
        int num1 = -1, num2 = -1;
        int count1 = 0, count2 = 0;
        
        for(int num : nums){
            if(num1 == num){
                count1++;
            }else if(num2 == num){
                count2++;
            }else if(count1 == 0){
                num1 = num;
                count1 = 1;
            }else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        //counting frequency of num1 and num2
        count1 = 0, count2 = 0;
        for(int num:nums)
        {
            if(num == num1)
                count1++;
            if(num == num2)
                count2++;
        }
        
        vector<int> res;
        
        // if all the element of array are same return only one element
        if(num1 != num2){
            if(count1 > nums.size()/3){
                res.push_back(num1);
            }
            if(count2 > nums.size()/3){
                res.push_back(num2);
            }
        }else{
            res.push_back(num1);
        }
        return res;
    }
};