class TimeMap {
public:
    // make record of timestamp for each key
    unordered_map<string, vector<int>> mp1;
    // make record of value for each timestamp
    unordered_map<int, string> mp2;
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        mp1[key].push_back(timestamp);
        mp2[timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        if(mp1[key].size() == 0){
            return "";
        }
        
        auto it = upper_bound(mp1[key].begin(), mp1[key].end(), timestamp);
        if(it == mp1[key].begin()){
            return "";
        }
        it--;
        //cout<<(*it)<<endl;
        return mp2[(*it)];
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */