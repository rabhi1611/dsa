class RandomizedSet {
public:
    unordered_map<int, bool>mp;
    RandomizedSet() {

    }
    
    bool insert(int val) {
        if(mp.count(val) > 0){
            return false;
        }        
        mp[val] = true;
        return true;
    }
    
    bool remove(int val) {
        if(mp.count(val) > 0){
            mp.erase(val);
            return true;
        }
        return false;
    }
    
    int getRandom() {
        int idx = rand() % mp.size();
        auto it = mp.begin();
        while(idx--){
            it++;
        }
        return  it -> first;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */