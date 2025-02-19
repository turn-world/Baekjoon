#include <bits/stdc++.h>
using namespace std;
int days[100001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int N,K;
    int ans=INT_MIN;
    cin >> N >> K;

    for(int i = 1; i <= N; i++)
    {
        cin >> days[i];
    }
    for(int i = 1; i <= N+1-K; i++)
    {
        int temp = 0;
        for(int j = i; j < i+K; j++)
        {
            temp += days[j];
        }
        ans = max(ans, temp);
    }
    cout << ans;
}
