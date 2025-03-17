#include <bits/stdc++.h>
using namespace std;
int cmp(string a, string b)
{
    if(a.length() == b.length())
    {
        return a<b;
    }
    else
    {
        return a.length() < b.length();
    }
}
int main()
{
    int n;
    cin >> n;
    string arr[20000];

    for(int i =0 ; i < n; i++)
    {
        cin >> arr[i];
    }

    sort(arr,arr+n,cmp);
    for(int i= 0; i <n; i++)
    {
        if(arr[i] == arr[i-1])
        {
            continue;
        }
        cout << arr[i] << "\n";
    }
}
