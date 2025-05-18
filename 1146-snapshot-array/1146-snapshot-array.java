class SnapshotArray {

    private Map<Integer, Integer> ls;
    private List<Map<Integer, Integer>> snapRec;
    
    public SnapshotArray(int length) {
        this.ls = new HashMap<>(length);
        this.snapRec = new ArrayList<>();
    }
    
    public void set(int index, int val) {
        ls.put(index, val);
    }
    
    public int snap() {
        snapRec.add(ls);
        ls = new HashMap<>();
        return snapRec.size() - 1;
    }
    
    public int get(int index, int snap_id) {
        
        for(int i = snap_id; i>= 0; i--){
            if(snapRec.get(i).containsKey(index)){
                return snapRec.get(i).get(index);
            }
        }

        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */