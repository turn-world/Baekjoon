#include <iostream>
#include <stack>
#include <string>
using namespace std;
int main() {
	int k;
	cin >> k;
	while (k--)
	{
		stack<char> st;
		string s;

		cin >> s;

		for (int i = 0; i < s.size(); i++) {
			if (st.empty()) {
				st.push(s[i]);
			}
			else {
				if (st.top() == '(' && s[i] == ')') {
					st.pop();
				}
				else {
					st.push(s[i]);
				}
			}
		}

		if (st.empty()) {
			cout << "YES" << "\n";
		}
		else {
			cout << "NO" << "\n";
		}
	}
}