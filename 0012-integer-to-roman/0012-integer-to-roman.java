class Solution {

    public String intToRoman(int num) {
        Map<Integer, String> mp = new LinkedHashMap<>();

        mp.put(1, "I");
        mp.put(4, "IV");
        mp.put(5, "V");
        mp.put(9, "IX");
        mp.put(10, "X");
        mp.put(40, "XL");
        mp.put(50, "L");
        mp.put(90, "XC");
        mp.put(100, "C");
        mp.put(400, "CD");
        mp.put(500, "D");
        mp.put(900, "CM");
        mp.put(1000, "M");

        List<Integer> ls = mp.entrySet().stream().map(k -> k.getKey()).toList();
        StringBuilder ans = new StringBuilder();

        int i = ls.size() - 1;

        while(num > 0){
            if(num >= ls.get(i)){
                ans.append(mp.get(ls.get(i)));
                num -= ls.get(i);
            } else {
                i -= 1;
            }
        }

        return ans.toString();
    }
}