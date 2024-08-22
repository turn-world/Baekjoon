#include <iostream>
using namespace std;

int main ()
{
    int n;
    cin >> n;
    int cnt[10] = {0};
    
    while(n>0){
        int x = n % 10;
        n/=10;
        
        if(x==9) cnt[6]++;
        else cnt[x]++;
    }
    
    cnt[6] = (cnt[6]+1) / 2;
    int max_cnt = 0;
    for(int i=0; i < 10; i++) max_cnt = max(max_cnt,cnt[i]);
    
    cout << max_cnt;
    
    return 0;
    
}