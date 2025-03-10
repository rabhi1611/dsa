class Solution {
    
    Map<List<Integer>, String> mp = new TreeMap<List<Integer>, String>(new Comparator<List<Integer>>()
    {
        public int compare(List<Integer> o1, List<Integer> o2)
        {
            return o1.get(0).compareTo(o2.get(0));
        } 
    });


    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < k; i++){
            int idx = indices[i];
            String src = sources[i];
            String tgt = targets[i];

            // isSrcPresent?
            if(isSrcPresent(s, idx, src)){
                // put src
                createRecord(idx, src, tgt);
            }
        }

        System.out.println(mp);

        AtomicInteger peIdx = new AtomicInteger(0);
        mp.entrySet().forEach(entry -> {
            int si = entry.getKey().get(0);
            int ei = entry.getKey().get(1);

            String val = entry.getValue();

            for(int i = peIdx.get(); i < si; i++){
                ans.append(s.charAt(i));
            }

            ans.append(val);
            
            peIdx.set(ei + 1);
        });

        for(int i = peIdx.get(); i < s.length(); i++){
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }


    private void createRecord(int sIdx, String src, String tgt){
        mp.put(Arrays.asList(sIdx, sIdx + src.length() - 1), tgt);
    }


    private boolean isSrcPresent(String s, int sIdx, String src){
        int i = sIdx;
        int j = 0;

        while(i < s.length() && j < src.length()){
            if(s.charAt(i) != src.charAt(j)){
                return false;
            }

            i += 1;
            j += 1;
        }

        if(i == s.length() && j == src.length()){
            return true;
        }

        if(i == s.length()){
            return false;
        }

        return true;
    }
}