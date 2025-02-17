#include <iostream>
using namespace std;

long long arr[101];

int main()
{
    arr[1] = 1;
    arr[2] = 1;
    arr[3] = 1;


    for(int i = 1; i <= 97; i++)
    {
        arr[i+3] = arr[i] + arr[i+1];
    }
    int T;
    cin>> T;
    while(T--)
    {
        int N;
        cin >> N;
        cout << arr[N] << endl;
    }
}
