#include <bits/stdc++.h>
using namespace std;
int stair[301];
int ans[301];
int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    stair[0] = 0;
    for(int i = 1; i <= N; i++)
    {
        cin >> stair[i];
    }
    ans[1] = stair[1];
    ans[2] = stair[1] + stair[2];
    ans[3] = max(stair[1] + stair[3], stair[2] + stair[3]);

    for(int i = 4; i <= N; i++)
    {
        ans[i] = max(ans[i-3] + stair[i] + stair[i-1],ans[i-2] + stair[i]);
    }
    cout << ans[N];
}
