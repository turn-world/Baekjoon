#include <bits/stdc++.h>
using namespace std;

int n,m,b;
int g[500][500];
int ans = INT_MAX;
int level;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m >> b;
    int temp;

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cin >> g[i][j];

        }
    }

    for(int h = 0; h <= 256; h++)
    {
        int x = 0;
        int y = 0;
        for(int i=0; i <n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(g[i][j] > h)
                {
                    y += g[i][j] - h;
                }else if(g[i][j] < h)
                {
                    x += h - g[i][j];
                }
            }
        }
        if(y+b >=x)
    {
        int time = y * 2 + x;
        if(ans >= time)
        {
            ans = time;
            level = h;
        }
    }
    }


    cout << ans << " " << level;
}
