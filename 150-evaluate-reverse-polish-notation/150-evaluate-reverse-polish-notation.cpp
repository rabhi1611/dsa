class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<string>st;
        for(auto x: tokens){
            if(x == "+"){
                //cout<<st.top()<<" ";
                string a = st.top();
                st.pop();
                string b = st.top();
                st.pop();
                st.push(to_string(stoi(b) + stoi(a)));               
                continue;
            }
            if(x == "-"){
                string a = st.top();
                st.pop();
                string b = st.top();
                st.pop();
                st.push(to_string(stoi(b) - stoi(a))); 
                continue;
                
            }
           if(x == "*"){
                string a = st.top();
                st.pop();
                string b = st.top();
                st.pop();
                st.push(to_string(stoi(b) * stoi(a))); 
                continue;
                 
            }
            if(x == "/"){
                string a = st.top();
                st.pop();
                string b = st.top();
                st.pop();
                st.push(to_string(stoi(b) / stoi(a))); 
                continue;
 
            }
            st.push(x);
        }
        return stoi(st.top());
    }
};