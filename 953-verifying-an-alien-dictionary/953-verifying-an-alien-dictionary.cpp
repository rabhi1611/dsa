class Solution {
public:
    int idx(char c,string order){
        unordered_map<char,int>m;
        for(int i=0;i<order.size();i++){
            m[order[i]]=i;
        }
        return m[c];
    }
    
    bool isAlienSorted(vector<string>& words, string order) {
        for(int i=0; i<words.size(); i++){
            for(int j=i+1; j<words.size(); j++){
                string a=words[i];
                string b=words[j];
                int k=0;
                while(k< a.size() && k<b.size()){
                    if(idx(a[k],order)> idx(b[k],order)){
                        return false;
                    }
                    else if(idx(a[k],order) < idx(b[k],order)){
                        break;
                    }else{
                        k++;
                    }
                }
                if(k==b.size() && k==a.size()){
                    continue;
                }
                if(a.size()<b.size()){
                    swap(a,b);
                }
                if(k==b.size()){
                    if(b==words[j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
};