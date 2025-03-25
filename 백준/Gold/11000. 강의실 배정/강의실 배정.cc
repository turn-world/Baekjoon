#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;
vector<pair<int,int>> v;
priority_queue<int, vector<int>, greater<int>> pq;
int ans = 0;

int main()
{
    int n;
    cin >> n;

    for(int i =0; i < n ;i++)
    {
        int temp1,temp2;
        cin >> temp1 >> temp2;
        v.push_back({temp1,temp2});
    }

    sort(v.begin(),v.end());
    pq.push(v[0].second);

    for(int i = 1; i < v.size(); i++)
    {
        if(v[i].first >= pq.top())
        {
            pq.pop();
            pq.push(v[i].second);
        }
        else
        {
            pq.push(v[i].second);
        }
    }
    cout << pq.size();
}
