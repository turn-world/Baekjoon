#include <iostream>
#include <stack>
using namespace std;

int main() {
	int n;
	int T;
	int cnt = 1;
	cin >> n;
	stack<int> st;
	while (n--)
	{
		cin >> T;

		if (cnt == T) cnt++;
		else { st.push(T);
		}

		while(!st.empty() && st.top() == cnt) {
			st.pop();
			cnt++;
		}
	}

	if (st.empty()) cout << "Nice"; 
	else cout << "Sad";
}