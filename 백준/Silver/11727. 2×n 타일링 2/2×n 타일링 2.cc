#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;

    int tile[1001];
    tile[1] = 1;
    tile[2] = 3;
    for(int i = 3; i <= 1000; i++)
    {
        tile[i] = (tile[i-1] + 2*tile[i-2])%10007;
    }
    cout << tile[n];
}
