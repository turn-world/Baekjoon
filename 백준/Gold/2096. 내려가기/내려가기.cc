#include <iostream>
using namespace std;
int n;
int arr[3];
int min_dp[3] = {0};
int max_dp[3] = {0};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    int tmp1,tmp2,tmp3;

    for(int i = 1; i <= n; i++)
    {
        cin >> arr[0] >> arr[1] >> arr[2];
        tmp1 = min_dp[0];
        tmp2 = min_dp[1];
        tmp3 = min_dp[2];

        min_dp[0] = min(tmp1,tmp2) + arr[0];
        min_dp[1] = min(min(tmp1,tmp2),tmp3) + arr[1];
        min_dp[2] = min(tmp2,tmp3) + arr[2];

        tmp1 = max_dp[0];
        tmp2 = max_dp[1];
        tmp3 = max_dp[2];

        max_dp[0] = max(tmp1,tmp2) + arr[0];
        max_dp[1] = max(max(tmp1,tmp2),tmp3) + arr[1];
        max_dp[2] = max(tmp2,tmp3) + arr[2];

    }

    cout << max(max(max_dp[0],max_dp[1]),max_dp[2]) << " " << min(min(min_dp[0],min_dp[1]),min_dp[2]);
}
