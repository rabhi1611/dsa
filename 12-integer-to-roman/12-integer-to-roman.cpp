class Solution {
public:
    vector<pair<int,char>>v;
    int idx=-1;
    void u_b(int s, int e, int t){
        if(s>e){
            return;
        }
        int mid = (s+e)/2;
        if(v[mid].first > t){
            u_b(s, mid - 1, t);
        }else{
            idx = mid;
            u_b(mid + 1, e, t);
        }
        return;
    }
    
    string intToRoman(int num) {
        
        v.push_back({1, 'I'});
        v.push_back({5, 'V'});
        v.push_back({10, 'X'});
        v.push_back({50, 'L'});
        v.push_back({100, 'C'});
        v.push_back({500, 'D'});
        v.push_back({1000, 'M'});
        
        string s="";
        int temp=1;
        while(num){
            int t = temp*(num%10);
            //temp=temp*(num%10);
            if(t == 4){
                s+="VI";
                temp=temp*10;
                num=num/10;
                continue;
            }
            if(t == 9){
                s+="XI";
                temp=temp*10;
                num=num/10;
                continue;
            }
            if(t == 40){
                s+="LX";
                temp=temp*10;
                num=num/10;
                continue;
            }
            if(t == 90){
                s+="CX";
                temp=temp*10;
                num=num/10;
                continue;
            }
            if(t == 400){
                s+="DC";
                temp=temp*10;
                num=num/10;
                continue;
            }
            if(t == 900){
                s+="MC";
                temp=temp*10;
                num=num/10;
                continue;
            }
            string st = "";
            while(t){
                u_b(0, v.size()-1, t);
                cout<<idx<<" ";
                if(idx == -1){
                    break;
                }else{
                    st += v[idx].second;
                    t = t - v[idx].first;
                }
            }
            reverse(st.begin(), st.end());
            s += st;
            temp=temp*10;
            num=num/10;
        }
        reverse(s.begin(), s.end());
        return s;
    }
};