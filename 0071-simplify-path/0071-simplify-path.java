class Solution {
    public String simplifyPath(String path) {
        String[] ls = path.split("/");
        Stack<String> fr = new Stack<>();

        for(int i = 0; i < ls.length; i += 1){
            if (ls[i].equals("") || ls[i].equals(".")) {
                
            } else if (ls[i].equals("..")) {
                if(!fr.isEmpty()){
                    fr.pop();
                }
            } else {
                fr.push(ls[i]);
            }
        };

        StringBuilder result = new StringBuilder();

        fr.stream().forEach(word -> {
            result.append("/").append(word);
        });

        if(result.toString().equals("")){
            result.append("/");
        }

        return result.toString();
    }
}