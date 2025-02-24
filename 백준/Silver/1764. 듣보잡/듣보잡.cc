#include <bits/stdc++.h>
using namespace std;
vector <string> listen_see;
map <string,int> kind;
int main()
{
    int N,M;
    string temp;
    cin >> N >> M;

    for(int i = 0; i < N+M; i++)
    {
        cin >> temp;
        kind[temp]++;
        if(kind[temp] > 1)
            listen_see.push_back(temp);
    }
    sort(listen_see.begin(), listen_see.end());
    cout << listen_see.size() << '\n';
    for(auto o: listen_see)
        cout << o <<'\n';
}
