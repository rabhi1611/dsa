class Solution {
public:
    vector<string> stringMatching(vector<string>& words) {
        vector<string>ans;
        for(int i=0;i<words.size();i++){
            bool found=false;
            for(int j=0;j<words.size();j++){
                if(found==true){
                    break;
                }
                if(i==j){
                    continue;
                }
                string bs=words[j];
                string ss=words[i];
                if(bs.size()<ss.size()){
                    continue;
                }
                int k=0;
                while(1){
                    if(k==bs.size()){
                        break;
                    }
                    if(bs[k]!=ss[0]){
                        k++;
                        continue;
                    }
                    
                    int t=k;
                    int l=0;
                    while(1){
                        if(found==true){
                            break;
                        }
                        if(t>=bs.size()){
                            break;
                        }
                        if(l>=ss.size()){
                           break;
                        }
                        if(ss[l]!=bs[t]){
                            break;
                        }
                        t++;
                        l++;
                    }
                    if(l==ss.size()){
                        ans.push_back(ss);
                        found=true;
                    }
                    k++;
                }
            }
        }
        return ans;
    }
};