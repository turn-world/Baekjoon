#include <bits/stdc++.h>
using namespace std;
int seq[1000001];
int ans[1000001];
stack <int> sto;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int N;

    cin >> N;
    for(int i = 0; i < N; i++)
    {
        cin >> seq[i];
    }

    for(int i = 0; i < N; i++)
    {
        while(!sto.empty() && seq[sto.top()] < seq[i])
        {
            ans[sto.top()] = seq[i];
            sto.pop();
        }
        sto.push(i);
    }

    while(!sto.empty())
    {
        ans[sto.top()] = -1;
        sto.pop();

    }
    for(int i = 0; i < N; i++)
    {
        cout << ans[i] << " ";
    }
}
