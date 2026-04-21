class Solution {
    public String simplifyPath(String path) {
        List<String> ls = Arrays.stream(path.split("/"))
        .filter(c -> {
            if(c == "/" || c == "") return false;
            return true;
        })
        .collect(Collectors.toList());

        Stack<String> fr = new Stack<>();

        ls.stream().forEach(word -> {
            if (word.equals(".")) {
                
            } else if (word.equals("..")) {
                if(!fr.isEmpty()){
                    fr.pop();
                }
            } else {
                fr.push(word);
            }
        });

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