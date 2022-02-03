class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        set<vector<int>>s;
        for(int i=0; i<nums.size() ;i++){
            int j = i+1;
            int k = nums.size()-1;
            while(j < k){
                if(nums[j] + nums[k] == (-1 * nums[i])){
                    vector<int>temp;
                    temp.push_back(nums[i]);
                    temp.push_back(nums[j]);
                    temp.push_back(nums[k]);
                    sort(temp.begin(), temp.end());
                    if(s.count(temp) > 0){
                        
                    }else{
                        s.insert(temp);
                    }
                    while(k-1>=0 && nums[k-1] == nums[k]){
                        k--;
                    }
                    while(j+1<nums.size() && nums[j+1] == nums[j]){
                        j++;
                    }
                    j++;
                    k--;
                }else if(nums[j] + nums[k] > (-1 * nums[i])){
                    while(k-1>=0 && nums[k-1] == nums[k]){
                        k--;
                    }
                    k--;
                }else{
                    while(j+1<nums.size() && nums[j+1] == nums[j]){
                        j++;
                    }
                    j++;
                }
            }
        }
        vector<vector<int>> ans;
        for(auto x:s){
            //cout<<x[0]<<" "<<x[1]<<" "<<x[2]<<endl;
            //cout<<nums[x[0]]<<" "<<nums[x[1]]<<" "<<nums[x[2]]<<endl;
            ans.push_back(x);
        }
        return ans;
    }
};