class Solution {
public:
    int compareVersion(string version1, string version2) {

        vector<int>v1;
        string temp= "";
        for(auto x: version1){
            if(x == '.'){
                v1.push_back(stoi(temp));
                temp = "";
                continue;
            }
            temp += x;
        }
        if(temp.size() != 0)
            v1.push_back(stoi(temp));
        
        vector<int>v2;
        temp = "";
        for(auto x: version2){
            if(x == '.'){
                v2.push_back(stoi(temp));
                temp = "";
                continue;
            }
            temp += x;
        }
        if(temp.size() != 0)
            v2.push_back(stoi(temp));
        
        for(auto x: v1){
            cout<<x<<" ";
        }
        cout<<endl;
        cout<<endl;
        for(auto x: v2){
            cout<<x<<" ";
        }
        cout<<endl;
        
        
        if(v1.size() > v2.size()){
            while(v2.size() != v1.size()){
                v2.push_back(0);
            }    
        }
        else if(v1.size() < v2.size()){
            while(v1.size() != v2.size()){
                v1.push_back(0);
            }
        }
        else{
            
        }
        
        cout<<endl;
        
         for(auto x: v1){
            cout<<x<<" ";
        }
        cout<<endl;
        cout<<endl;
        for(auto x: v2){
            cout<<x<<" ";
        }
        cout<<endl;
        
        int result = 0;
        int i=0;
        int j=0;
        while(i < v1.size()){
            if(v1[i] == v2[j]){
                i++;
                j++;
                continue;
            }
            if(v1[i] > v2[j]){
                result = 1;
                break;
            }else{
                result = -1;
                break;
            }
            i++;
            j++;
        }
        
        return result;
    }
};