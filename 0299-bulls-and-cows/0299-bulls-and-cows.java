class Solution {
    public String getHint(String secret, String guess) {
        
        StringBuilder ans = new StringBuilder();

        Map<Integer, Character> secretMap1 = new HashMap<>();
        Map<Character, Integer> secretMap2 = new HashMap<>();
        
        for(int i = 0; i < guess.length(); i++){
            char c = guess.charAt(i);
            secretMap1.put(i, c);
            secretMap2.put(c, secretMap2.getOrDefault(c, 0) + 1);
        }

        int bullsCnt = 0, cowsCnt = 0;

        for(int i = 0; i < secret.length(); i++){
            char sc = secret.charAt(i);
            char gc = secretMap1.get(i);

            // equals one
            if(sc == gc){
                if(secretMap2.containsKey(sc)){
                    bullsCnt += 1;
                    secretMap2.put(sc, secretMap2.get(sc) - 1);
                    if(secretMap2.get(sc) == 0){
                        secretMap2.remove(sc);
                    }
                }
            }
        }

        for(int i = 0; i < secret.length(); i++){
            char sc = secret.charAt(i);
            char gc = secretMap1.get(i);

            // equals one
            if(sc != gc){
                if(secretMap2.containsKey(sc)){
                    cowsCnt += 1;
                    secretMap2.put(sc, secretMap2.get(sc) - 1);
                    if(secretMap2.get(sc) == 0){
                        secretMap2.remove(sc);
                    }
                }
            }
        }


        ans.append(bullsCnt).append('A').append(cowsCnt).append('B');

        return ans.toString();
    }
}