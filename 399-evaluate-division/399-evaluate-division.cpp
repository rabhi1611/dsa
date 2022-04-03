class Solution {
    class Graph{
        unordered_map<string, unordered_map<string, double>> mpp;
        public:
        void addEdge(string x, string y, double division)
        {
            mpp[x][y] = division;
            mpp[y][x] = 1/division;
        }
        
        double bfs(string x, string y)
        {
            unordered_map<string, bool> check;
            for(auto i : mpp)
            {
                check[i.first] = false;
            }
            queue<pair<string, double>> q;
            q.push(make_pair(x, 1.0));
            
            while(!q.empty())
            {
                string frontValue = q.front().first;
                double secondValue = q.front().second;
                q.pop();
                check[frontValue] = true;
                for(auto nbr : mpp[frontValue])
                {
                    if(!check[nbr.first])
                    {
                        double multiply = secondValue*(mpp[frontValue][nbr.first]);
                        if(nbr.first == y)
                        {
                            return multiply;
                        }
                        q.push(make_pair(nbr.first, multiply));
                    }
                    
                }
            }
            return -1.00000; 
        }
        
        double query(string x, string y)
        {
            double ans = -1.00000;
            if(mpp.count(x) > 0 && mpp.count(y) > 0)
            {
                if(x == y) return 1.00000;
                ans = bfs(x, y);
                return ans;
            }
            return ans;
        }
    };
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
        vector<double> ans;
        Graph g;
        for(int i=0; i<values.size(); i++)
        {
            string x = equations[i][0];
            string y = equations[i][1];
            double value = values[i];
            g.addEdge(x,y,value);
        }
        
        for(int i=0; i<queries.size(); i++)
        {
            string x = queries[i][0];
            string y = queries[i][1];
            double tempAns = g.query(x, y);
            ans.push_back(tempAns);
        }
        return ans;
    }
};