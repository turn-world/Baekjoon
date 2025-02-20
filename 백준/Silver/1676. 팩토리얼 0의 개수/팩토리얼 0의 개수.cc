#include<iostream>
using namespace std;

int main(void)
{
	int cnt = 0;
	int n;
	cin >> n;
    
	for (int i = 1; i <= n; i++)
	{
		if (i % 5 == 0)		//	5의 배수일 때
		{
			cnt++;
			if (i % 25 == 0)		//	25의 배수일 때
				cnt++;
			if (i % 125 == 0)		//	125의 배수일 때
				cnt++;
		}
	}
    
	cout << cnt;
}