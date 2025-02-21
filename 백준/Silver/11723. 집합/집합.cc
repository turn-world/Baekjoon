#include <bits/stdc++.h>
using namespace std;
int S[21] = {0};

void add(int num)
{
    if(S[num] ==0)
        S[num] = 1;
}
void remove_fun(int num)
{
    if(S[num] == 1)
        S[num] = 0;
}
void check(int num)
{
    if(S[num] == 1)
        cout << "1\n";
    else
        cout << "0\n";
}
void toggle(int num)
{
    if(S[num] == 1)
        S[num] = 0;
    else
        S[num] = 1;
}
int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    int M;
    cin >> M;
    string menu;
    int num;

    for(int i = 0; i < M; i++)
    {
        cin >> menu;
        if(menu == "add")
        {
            cin >> num;
            add(num);
        }
        else if(menu == "remove")
        {
            cin >> num;
            remove_fun(num);
        }
        else if(menu == "check")
        {
            cin >> num;
            check(num);
        }
        else if(menu == "toggle")
        {
            cin >> num;
            toggle(num);
        }
        else if(menu == "all")
        {
            for(int i =1; i<=20; i++)
                S[i] =1;
        }
        else if(menu == "empty")
        {
            for(int i =1; i<=20; i++)
                S[i] =0;
        }
    }
}
