class PairJ{
public:
    int a; 
    int b; 
    int j; 
    PairJ(int a, int b, int j) : a(a), b(b), j(j) {};
};

class PairJGreater{
public:
    PairJGreater(){};
    bool operator() (const PairJ* p1, const PairJ* p2){
        return p1->a + p1->b > p2->a + p2->b;
    }
};

class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<vector<int>> ans;
        
        if(nums1.size() == 0 || nums2.size() == 0 || k == 0) return ans;
        
        priority_queue<PairJ*, vector<PairJ*>, PairJGreater> pq;
        for(int i = 0; i < k && i < nums1.size(); i++){
            pq.push(new PairJ(nums1[i], nums2[0], 0));
        }
        
        while(k-- > 0 && !pq.empty()){
            PairJ* p = pq.top(); pq.pop();
            ans.push_back({p->a, p->b});
            if(p->j+1 >= nums2.size()) continue;
            pq.push(new PairJ(p->a, nums2[p->j+1], p->j+1));
        }
        
        return ans;
    }
};