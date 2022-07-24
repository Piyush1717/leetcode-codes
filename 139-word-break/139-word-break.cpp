class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
                int n = s.size();
        bool dp[n+1][n+1];
        
        unordered_set<string> myset;
        for(auto word: wordDict)
            myset.insert(word);
        
        for(int length=1;length<=n;++length) //Window Size
        {
            int start = 1;
            int end = length;
            while(end<=n) //Sliding Window
            {
                string temp = s.substr(start-1,length);
                if(myset.find(temp)!=myset.end())
                    dp[start][end] = true;
                else
                {
                    bool flag = false;
                    for(int i=start;i<end;++i)
                        if(dp[start][i] and dp[i+1][end])
                        {
                            flag = true;
                            break;
                        }
                    dp[start][end] = flag;
                }
                start += 1;
                end += 1;
            }
        }
        return dp[1][n];
    }
};