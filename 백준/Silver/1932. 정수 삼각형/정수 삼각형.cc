#include <bits/stdc++.h>
using namespace std;
int dp[500][500];
int sp[500];
int main()
{
    int n; cin >> n;
    int ans = INT_MIN;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j <= i; j++)
        {
            cin >> sp[j];
        }
        if(i==0)
        {
             dp[i][0] = sp[0];
             ans = max(ans,dp[i][0]);
             continue;
        }

        for(int j = 0; j <= i; j++)
        {
            if(j==0)
                dp[i][j] = dp[i-1][j] + sp[j];
            else if(j==i)
                dp[i][j] = dp[i-1][j-1] + sp[j];
            else
                dp[i][j] = max(dp[i-1][j-1]+sp[j],dp[i-1][j]+sp[j]);

            ans = max(ans,dp[i][j]);
        }
    }
    cout << ans;
}
