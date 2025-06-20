import java.util.Collections;

class TimeMap {
    Map<Pair<String, Integer>, String> keyTimeValueMap;
    Map<String, List<Integer>> keyTimeMap;

    public TimeMap() {
        this.keyTimeValueMap = new HashMap<>();
        this.keyTimeMap = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        timestamp -= 1;
        this.keyTimeValueMap.put(new Pair<>(key, timestamp), value);
        List<Integer> tr = this.keyTimeMap.getOrDefault(key, new ArrayList<>());
        tr.add(timestamp);
        this.keyTimeMap.put(key, tr);
    }
    
    public String get(String key, int timestamp) {
        timestamp -= 1;

        if(this.keyTimeValueMap.containsKey(new Pair<>(key, timestamp))){
            return this.keyTimeValueMap.get(new Pair<>(key, timestamp));
        } else {
            if(this.keyTimeMap.containsKey(key)){
                // ?
                List<Integer> tr = this.keyTimeMap.get(key);
                //Collections.sort(tr);
                int idx = Collections.binarySearch(tr, timestamp);

                if(idx >= 0){
                    // present hai
                    return this.keyTimeValueMap.get(new Pair<>(key, tr.get(idx)));
                } 

                int preIndx = Math.abs(idx) - 2;
                if(preIndx >= 0){
                    return this.keyTimeValueMap.get(new Pair<>(key, tr.get(preIndx)));
                }

                return ""; 
            } else {
                return "";
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */