#include <iostream>
#include <algorithm>
using namespace std;

int dp[1001];
int r_dp[1001];
int arr[1001];
void Dp(int n)
{
    for(int i = 1; i <= n; i++)
    {
        dp[i] = 1;
        for(int j = 1; j <= i; j++)
        {
            if(arr[j] < arr[i] && dp[i] < dp[j] + 1)
            {
                dp[i] = dp[j] +1;
            }
        }
    }

    for(int i = n; i >= 1; i--)
    {
        r_dp[i] = 1;
        for(int j = n; j >= i; j--)
        {
            if(arr[i] > arr[j] && r_dp[i] < r_dp[j] + 1)
            {
                r_dp[i] = r_dp[j] + 1;
            }
        }
    }

    int ans = 0;
    for(int i = 0; i <= n; i++)
    {
        ans = max(ans,dp[i] + r_dp[i] -1);
    }

    cout << ans;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int n;
    cin >> n;
    for(int i =1; i<=n ; i++)
    {
        cin >> arr[i];
    }

    Dp(n);
}
