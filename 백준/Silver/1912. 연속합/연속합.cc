#include <bits/stdc++.h>
using namespace std;

vector <int> arr;
int d[100001];
int main()
{
    ios::sync_with_stdio(0);    cin.tie(0);

    int n; cin >> n;
    for (int i = 0; i <n ;i++)
    {
        int space;
        cin >> space;
        arr.push_back(space);
    }

    int ans = INT_MIN;
    for(int i = 0; i < n; i++)
    {
        d[i] = max(arr[i], d[i-1]+arr[i]);
        ans = max(ans,d[i]);
    }
    cout << ans;
}
