#include <bits/stdc++.h>
using namespace std;
#define MAX 101

int graph[MAX][MAX];
queue <int> q;
int n,pair_com;
int Count = 0;
bool visited[MAX] = {0, };
void bfs(int s)
{
    q.push(s);
    visited[s] = true;
    while(!q.empty())
    {
        s = q.front();
        q.pop();

        for(int i = 1; i <= n; i++)
        {
            if(graph[s][i] == 1 && visited[i] == 0)
            {
                q.push(i);
                visited[i] = true;
                Count++;
            }
        }
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    cin >> n;
    cin >> pair_com;
    for(int i = 0; i < pair_com; i++)
    {
        int temp1,temp2;
        cin >> temp1 >> temp2;
        graph[temp1][temp2] = 1;
        graph[temp2][temp1] = 1;
    }
    bfs(1);
    cout << Count <<'\n';
}
