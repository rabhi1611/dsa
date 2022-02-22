class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        
        vector<int> v1;
        for(int i = 0; i < nums1.size(); i++){
            for(int j = 0; j < nums2.size(); j++){
                //cout<<nums1[i] + nums2[j]<<" "; 
                v1.push_back(nums1[i] + nums2[j]);
            }
        }
        cout<<endl;
        unordered_map<int,int>mp;
        //list<int>l1;
        for(int i = 0; i < nums3.size(); i++){
            for(int j = 0; j < nums4.size(); j++){
                //cout<<nums3[i] + nums4[j]<<" ";
                mp[nums3[i] + nums4[j]]++;
          //      l1.push_back(nums3[i] + nums4[j]);
            }
        }
        cout<<endl;
        //l1.sort();
        int c = 0;
        for(auto x: v1){
            //cout<<(-1) * (x)<<" "<<mp[(-1) * (x)]<<endl;
            if(mp[(-1) * (x)] > 0){
                //mp[(-1) * (x)]--;      
                c += mp[(-1) * (x)];
            } 
        }
        return c;
    }
};